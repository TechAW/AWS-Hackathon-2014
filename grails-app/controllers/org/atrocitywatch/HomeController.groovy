package org.atrocitywatch


import grails.plugin.springsecurity.annotation.Secured

class HomeController {

	def SpringSecurityService
	def NotificationService

    def index() { 
		def user = springSecurityService.principal.username
		println user
	}

	def notifytest() {
		User user=SpringSecurityService.currentUser
		NotificationService.notify(user,"AtrocityWatch Alert","AtrocityWatch Alert")
	}
	
	def toggleAlert() {
		NotificationService.toggleAlert()
	}
	
	def getAlert() {
		render(NotificationService.getAlert())
	}
}
