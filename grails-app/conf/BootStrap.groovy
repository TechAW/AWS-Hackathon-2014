import grails.converters.JSON

import org.atrocitywatch.Event
import org.atrocitywatch.EventSimulationJob
import org.atrocitywatch.Location
import org.atrocitywatch.Role
import org.atrocitywatch.User
import org.atrocitywatch.UserRole

class BootStrap {

	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}

	def grailsApplication
	def fixedEvents=false

	def init = { servletContext ->
		println 'Bootstrapping'
		def adminRole = new Role(authority: "ROLE_ADMIN").save()
		def userRole = new Role(authority: "ROLE_USER").save()
		createUser('admin', 'awatch', adminRole)
		createUser('user', 'awatch', userRole)

		def users = [
			[
				username: 'bennett',
				phone: '7034072881',
				email: 'swb1701@gmail.com'
			], [
				username: 'ayasein',
				phone: '5712410343',
				email: 'ayasein@gmail.com'
			], [
				username: 'conn',
				phone: '7346498544',
				email: 'bcconn2112@gmail.com'
			], [
				username: 'jd',
				phone: '+358503011297',
				email: 'jdahlbom@gmail.com'
			], [
				username: 'jian',
				phone: '4084380882',
				email: 'cmti95035@gmail.com'
			]
		].collect {
			User user = new User(username: it.username, password: it.username, phone: it.phone, email: it.email, enabled:true);
			user.save();
			UserRole.create(user, adminRole, true);
			return user;
		}
		def loc=null
		if (fixedEvents) {
			def event=new Event(name:"Palazzo North",date:new Date(),lat:36.12291467,lon:-115.1701813,radius:50)
			event.save()
			event=new Event(name:"Palazzo Bridge West",date:new Date(),lat:36.12209934,lon:-115.17092013,radius:50)
			event.save()
			event=new Event(name:"Palazzo Bridge East",date:new Date(),lat:36.12177812,lon:-115.17090964,radius:50)
			event.save()
		} else {
			loc=new Location(name:"ReInvent",lat:36.1228431,lon:-115.1704714,radius:1000)
			loc.save()
			def vjson=grailsApplication.parentContext.getResource("data/vegas.json").file.text
			def json=JSON.parse(vjson)
			json.each {
				loc=new Location(name:it.name,lat:it.latitude,lon:it.longitude,radius:1000)
				loc.save()
			}
		}
		Random rand=new Random()
		User.list().each { u ->
			if (!fixedEvents) {
				//assign up to two random locations
				loc=Location.all[rand.nextInt(Location.all.size())]
				if (u.locations==null || !u.locations.contains(loc)) {
					u.addToLocations(loc)
				}
				loc=Location.all[rand.nextInt(Location.all.size())]
				if (u.locations==null || !u.locations.contains(loc)) {
					u.addToLocations(loc)
				}
			}
			u.currentLocation = new Location(name: 'Current Location', lat: 0, lon: 0, radius: 50).save()
			u.save()
		}
		//if (!fixedEvents) EventSimulationJob.schedule(10000)
	}

	def destroy = {
	}
}
