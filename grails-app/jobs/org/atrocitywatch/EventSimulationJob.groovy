package org.atrocitywatch

class EventSimulationJob {
	
	Random rand=new Random()
	int cnt=0
	
	static triggers = {
		//simple startDelay: 30000, repeatInterval: 60000
	}

	def execute() {
	  println("Simulated Event Posting")
	  def rloc=Location.all[rand.nextInt(Location.all.size())]
	  cnt++
	  def event=new Event(name:"Atrocity Report "+cnt,lat:rloc.lat,lon:rloc.lon,500)
	  event.save()
	}
}
