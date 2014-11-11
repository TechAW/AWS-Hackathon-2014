dataSource {
	pooled = true
	driverClassName = "org.postgresql.Driver"
	dialect = "org.hibernate.dialect.PostgreSQLDialect"
	//dialect = "net.sf.hibernate.dialect.PostgreSQLDialect"
	username="hackadmin"
	password = "atrocity"

}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
	//cache.provider_class='org.hibernate.cache.EhCacheProvider'
}


// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:postgresql://hackathon.cfodw8cvyhuc.us-west-2.rds.amazonaws.com:5432/atrocity"		
		}
	}
	test {
		dataSource {
			dbCreate = "create-drop"
		   url = "jdbc:postgresql://hackathon.cfodw8cvyhuc.us-west-2.rds.amazonaws.com:5432/atrocity"
		}
	}
	production {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:postgresql://hackathon.cfodw8cvyhuc.us-west-2.rds.amazonaws.com:5432/atrocity"
		}
	}
}