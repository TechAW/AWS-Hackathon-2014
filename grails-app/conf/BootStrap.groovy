import org.atrocitywatch.User
import org.atrocitywatch.Role
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
		
		[
			[
				username: 'bennett',
				phone: '7034072881',
				email: 'swb1701@gmail.com'
			],
			[
				username: 'ayasein',
				phone: '5712410303',
				email: 'ayasein@gmail.com'
			],
			[
				username: 'conn',
				phone: '7346498544',
				email: 'bcconn2112@gmail.com'
			],
			[
				username: 'jd',
				phone: '+358503011297',
				email: 'jdahlbom@gmail.com'
			],
			[
				username: 'milo',
				phone: '2063106618',
				email: 'milomilo@trove.com'
			],
		].each {
			User user = new User(username: it.username, password: it.username, phone: it.phone, email: it.email, enabled:true);
			user.save();
			UserRole.create(user, adminRole, true);
		}
		
    }
	
    def destroy = {
    }
}
