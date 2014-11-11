package org.atrocitywatch

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	String phone
	String email

	static transients = ['springSecurityService']

	static constraints = {
		table "`user`"
		username blank: false, unique: true
		password blank: false
		phone nullable: true
		email nullable: true
	}
	
	static hasMany=[locations:Location]
	
	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
