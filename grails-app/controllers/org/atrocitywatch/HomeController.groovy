package org.atrocitywatch

import grails.plugin.springsecurity.annotation.Secured
import org.atrocitywatch.EventSimulationJob

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

	def createEvents() {
		EventSimulationJob.schedule(3000, 5)
		redirect(controller: 'account', action: 'map')
	}
	
	def toggleAlert() {
		NotificationService.toggleAlert()
		redirect(action: 'index')
	}
	
	def getAlert() {
		render(NotificationService.getAlert())
	}
}
