package org.atrocitywatch

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class AccountController {
	
	def springSecurityService

    def index() { }
	
	@Secured(["ROLE_ADMIN", "ROLE_USER"])
	def profile() {
		User me = springSecurityService.currentUser;
		[username: me.username, locations: me.locations]
	}
	
	def create() {
		
	}
	
	def submitCreation() {
		if (!params.username) {
			flash.message = 'Please input a username.'
			redirect(action: 'create');
		} else if (!params.password) {
			flash.message = 'Please input a password.'
			redirect(action: 'create');
		} else if (!params.phone && !params.email) {
			flash.message = 'Please input a phone number or email address.'
			redirect(action: 'create');
		} else {
			String username = params.username ?: 'user' + User.count();
			User user = new User(username: username, password: params.password, phone: params.phone, email: params.email);
			user.save();
			if (user.hasErrors()) {
				flash.message = 'There was an error creating the account. Please make sure your username is unique.'
				redirect(action: 'create');
			} else {
				UserRole.create(user, Role.findByAuthority("ROLE_USER"), true);
				flash.message = 'Your account was created successfully, please log in to see your account.'
				redirect(action: 'index')
			}
		}
	}
	
	@Secured(["ROLE_ADMIN", "ROLE_USER"])
	def addLocation() {
		User me = springSecurityService.currentUser;
		if (params.name && params.lat && params.lng && params.radius) {
			Location loc = new Location(name: params.name, lat: params.lat.toDouble(), lon: params.lng.toDouble(), radius: params.radius.toDouble());
			loc.save();
			if (loc.hasErrors()) {
				render([success: false, error: 'There was an error creating the location. Please try again.'] as JSON);
			} else {
				me.addToLocations(loc);
				render([success: true] as JSON);
			}
		} else {
			render([success: false, error: 'Please input a valid name, latitude, longitude, and radius.'] as JSON);
		}
	}
}
