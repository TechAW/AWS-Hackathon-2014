import org.atrocitywatch.User
import org.atrocitywatch.Role
import org.atrocitywatch.User
import org.atrocitywatch.UserRole

class BootStrap {
	
	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}

    def init = { servletContext ->
		println 'Bootstrapping'
		def adminRole = new Role(authority: "ROLE_ADMIN").save()
		def userRole = new Role(authority: "ROLE_USER").save()
		createUser('admin', 'awatch', adminRole)
		createUser('user', 'awatch', userRole)
		
		def user=new User(username:"bennett",password:"bennett",phone:"7034072881",email:"swb1701@gmail.com",enabled:true)
		user.save()
		user=new User(username:"ayasein",password:"ayasein",phone:"5712410303",email:"ayasein@gmail.com",enabled:true)
		user.save()
		user=new User(username:"conn",password:"conn",phone:"5712062178",email:"bcconn2112@gmail.com",enabled:true)
		user.save()
		user=new User(username:"jd",password:"jd",phone:"+358503011297",email:"jdahlbom@gmail.com",enabled:true)
		user.save()
		user=new User(username:"milo",password:"milo",phone:"2063106618",email:"milomilo@trove.com",enabled:true)
		user.save()
    }
	
    def destroy = {
    }
}
