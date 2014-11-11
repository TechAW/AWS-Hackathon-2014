package org.atrocitywatch

import grails.converters.JSON

class HomeController {

	def SpringSecurityService
	def NotificationService

    def index() { }

	def notifytest() {
		User user=SpringSecurityService.currentUser
		NotificationService.notify(user,"AtrocityWatch Alert","AtrocityWatch Alert")
	}

	def grailsApplication	
	def testJson() {
		def vjson=grailsApplication.parentContext.getResource("data/vegas.json").file.text
		def json=JSON.parse(vjson)
		println(json)
		json.each { 
			println(it.latitude+" "+it.longitude+" "+it.name)
		}
	}
}
