package org.atrocitywatch

class HomeController {

	def SpringSecurityService
	def NotificationService

    def index() { }

	def notifytest() {
		User user=SpringSecurityService.currentUser
		NotificationService.notify(user,"AtrocityWatch Alert","AtrocityWatch Alert")
	}
}
