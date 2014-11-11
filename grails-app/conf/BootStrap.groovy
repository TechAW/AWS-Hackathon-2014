import grails.converters.JSON

import org.atrocitywatch.Location
import org.atrocitywatch.Role
import org.atrocitywatch.User
import org.atrocitywatch.UserRole
import org.atrocitywatch.EventSimulationJob

class BootStrap {
	
	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}
	
	def grailsApplication

    def init = { servletContext ->
		println 'Bootstrapping'
		def adminRole = new Role(authority: "ROLE_ADMIN").save()
		def userRole = new Role(authority: "ROLE_USER").save()
		createUser('admin', 'awatch', adminRole)
		createUser('user', 'awatch', userRole)
		
		def users=[]
		def user=new User(username:"bennett",password:"bennett",phone:"7034072881",email:"swb1701@gmail.com",enabled:true)
		users<<user
		user.save()
		UserRole.create(user, adminRole, true)
		user=new User(username:"ayasein",password:"ayasein",phone:"5712410303",email:"ayasein@gmail.com",enabled:true)
		users<<user
		user.save()
		UserRole.create(user, adminRole, true)
		user=new User(username:"conn",password:"conn",phone:"7346498544",email:"bcconn2112@gmail.com",enabled:true)
		users<<user
		user.save()
		UserRole.create(user, adminRole, true)
		user=new User(username:"jd",password:"jd",phone:"+358503011297",email:"jdahlbom@gmail.com",enabled:true)
		users<<user
		user.save()
		UserRole.create(user, adminRole, true)
		user=new User(username:"milo",password:"milo",phone:"2063106618",email:"milomilo@trove.com",enabled:true)
		users<<user
		user.save()
		UserRole.create(user, adminRole, true)
		
	    def loc=new Location(name:"ReInvent",lat:36.1228431,lon:-115.1704714,radius:2500)
		loc.save()
		def vjson=grailsApplication.parentContext.getResource("data/vegas.json").file.text
		def json=JSON.parse(vjson)
		json.each {
			loc=new Location(name:it.name,lat:it.latitude,lon:it.longitude,radius:1000)
			loc.save()
		}
		Random rand=new Random()
		users.each { u ->
			//assign up to two random locations
			loc=Location.all[rand.nextInt(Location.all.size())]
			if (u.locations==null || !u.locations.contains(loc)) {
			  u.addToLocations(loc)
			}
			loc=Location.all[rand.nextInt(Location.all.size())]
			if (u.locations==null || !u.locations.contains(loc)) {
			  u.addToLocations(loc)
			}
		    u.save()	
		}
		EventSimulationJob.schedule(10000)
    }
	
    def destroy = {
    }
}
