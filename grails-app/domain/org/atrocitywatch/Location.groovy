package org.atrocitywatch

class Location {
	
	String name
	double lat
	double lon
	double radius

    static constraints = {
		
    }
	static mapping = {
		table '`location`'

	}
}
