package org.atrocitywatch

import java.util.Random;

import grails.transaction.Transactional

@Transactional
class EventSimulationService {

	Random rand=new Random()
	int cnt=0
	def SearchService

	def addEvent() {
		println("Simulated Event Posting")
		def rloc=Location.all[rand.nextInt(Location.all.size())]
		cnt++
		double latdisp=rand.nextDouble()*200
		double londisp=rand.nextDouble()*200
		double nlat=SearchService.newLat(rloc.lat,latdisp-100)
		double nlon=SearchService.newLng(rloc.lat,rloc.lon,londisp-100)
		def event=new Event(name:"Atrocity Report "+cnt,date:new Date(),lat:nlat,lon:nlon,radius:500)
		event.save(flush:true)
		SearchService.checkNewEvent(event)
		if (event.hasErrors()) {
			println(event.errors)
		}
		//println("event="+event)
	}
}
