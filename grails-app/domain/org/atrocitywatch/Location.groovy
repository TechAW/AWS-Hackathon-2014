package org.atrocitywatch

class Location {
	
	String name
	long lat
	long lon
	double radius

    static constraints = {
    }
	static mapping = {
		table '`location`'

	}
}
