package org.atrocitywatch

class Person {
	
	String username
	String phone
	String email
	
	static hasMany=[locations:Location]

    static constraints = {
		phone nullable: true
		email nullable: true
    }
}
