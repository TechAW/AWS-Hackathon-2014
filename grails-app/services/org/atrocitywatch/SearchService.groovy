package org.atrocitywatch

import grails.transaction.Transactional

@Transactional
class SearchService {

    Collection<Event> checkLocation(Location loc) {
		double minLat = newLat(loc.lat, -loc.radius);
		double maxLat = newLat(loc.lat, loc.radius);
		double minLng = newLng(loc.lat, loc.lon, -loc.radius);
		double maxLng = newLng(loc.lat, loc.lon, loc.radius);
		Collection<Event> events = Event.createCriteria().list {
			and {
				between("lat", minLat, maxLat)
				between("lon", minLng, maxLng)
			}
		}
		return events;
    }
	
	double newLat(double lat, double feet) {
		double rad = 20925524.9 * 2 * Math.PI;
		return lat + feet / rad * 360;
	}
	
	double newLng(double lat, double lng, double feet) {
		double rad = 20925524.9 * 2 * Math.PI * Math.cos(lat / 180 * Math.PI);
		return lng + feet / rad * 360;
	}
}
