package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Sim sim1 = new Sim();
		sim1.setProvider("Jio");
		sim1.setType("4G");
		sim1.setImei(10);
		
		Sim sim2 = new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("3G");
		sim2.setImei(81);
		
		Sim sim3 = new Sim();
		sim3.setProvider("BSNL");
		sim3.setType("2G");
		sim3.setImei(26);
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		
		Mobile mobile1 = new Mobile();
		mobile1.setName("Samsung");
		mobile1.setCost(16000);
	
		
		mobile1.setSims(sims);
		
		sim1.setMobile(mobile1);
		sim2.setMobile(mobile1);
		sim3.setMobile(mobile1);
		
		entityTransaction.begin();
//		entityManager.persist(sim1);
//		entityManager.persist(sim2);
		
		/* saving the child will save parent entity as well , need not persist separately */ 
		
		entityManager.persist(mobile1);
		entityTransaction.commit();
		
	}
}
