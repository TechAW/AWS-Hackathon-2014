// MySQL
/*dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	username="username"
	password="password"
	
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 1
		initialSize = 1
   
		numTestsPerEvictionRun = 3
		maxWait = 10000
   
		testOnBorrow = true
		testWhileIdle = true
		testOnReturn = true
   
		validationQuery = "select now()"
   
		minEvictableIdleTimeMillis = 1000 * 60 * 5
		timeBetweenEvictionRunsMillis = 1000 * 60 * 5
	 }
}*/
/*dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}*/
// environment specific settings
// MySQL
/*environments {
	development {
		dataSource {
			dbCreate = "update"
			url = 'jdbc:mysql://<URL>/<DB>?useUnicode=true&autoReconnect=true'
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = 'jdbc:mysql://<URL>/<DB>?useUnicode=true&autoReconnect=true'
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = 'jdbc:mysql://<URL>/<DB>?useUnicode=true&autoReconnect=true'
		}
	}
}*/
/*environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    staging {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:h2:legaltrackerDevDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:legaltrackerDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
*/
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
	//cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
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