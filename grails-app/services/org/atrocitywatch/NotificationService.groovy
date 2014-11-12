package org.atrocitywatch

import grails.transaction.Transactional

@Transactional
class NotificationService {

	def mailService
	def twilioSenderService
	
	def alert=false
	
	def toggleAlert() {
		alert=!alert
	}
	
	def getAlert() {
		return(alert)
	}

    def notify(User user,subject,msg) {
      if (user.email!=null) {
		  //notifyByEmail(user,subject,msg)
	  }
	  if (user.phone!=null) {
		  notifyBySMS(user,subject,msg)
	  }
    }

	def notifyByEmail(User user,String subj,String msg) {
		mailService.sendMail {
			multipart false
			to user.email
			from  'attrocitywatch@theconnman.com'
			subject subj.toString()
			html msg
		}
	}

	def notifyBySMS(User user,String subject,String msg) {
		twilioSenderService.sendSMS(user.phone, msg);
	}
}
