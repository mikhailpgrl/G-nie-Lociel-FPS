package com.g4.dao.datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

// Clas tha generate the persistence manager factory
final class PersistenceFactory {

	static PersistenceManagerFactory getFactory(){
		
		return JDOHelper.getPersistenceManagerFactory("Flight");
	}
}
