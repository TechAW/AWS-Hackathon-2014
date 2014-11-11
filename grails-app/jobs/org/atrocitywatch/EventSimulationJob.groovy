package org.atrocitywatch

class EventSimulationJob {

	static triggers = {
		//simple startDelay: 30000, repeatInterval: 60000
	}

	def EventSimulationService

	def execute() {
		EventSimulationService.addEvent()
	}
}
