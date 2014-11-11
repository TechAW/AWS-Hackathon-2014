package org.atrocitywatch

import java.util.Random;

import grails.transaction.Transactional

@Transactional
class EventSimulationService {

	Random rand=new Random()
	int cnt=0

	def addEvent() {
		println("Simulated Event Posting")
		def rloc=Location.all[rand.nextInt(Location.all.size())]
		cnt++
		def event=new Event(name:"Atrocity Report "+cnt,date:new Date(),lat:rloc.lat,lon:rloc.lon,radius:500)
		event.save(flush:true)
		if (event.hasErrors()) {
			println(event.errors)
		}
		println("event="+event)
	}
}
