package org.atrocitywatch

import grails.plugin.springsecurity.annotation.Secured

class AccountController {

    def index() { }
	
	@Secured(["ROLE_ADMIN","ROLE_USER"])
	def profile() {
		
	}
	
	def create() {
		
	}
	
	def submitCreation() {
		
	}
}
