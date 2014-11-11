package org.atrocitywatch

import grails.plugin.springsecurity.annotation.Secured

class AccountController {

    def index() { }
	
	@Secured(["ROLE_ADMIN", "ROLE_USER"])
	def profile() {
		
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
}
