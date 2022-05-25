package com.ty.onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Hospital;
import com.ty.onetomany.dto.Branch;

public class TestSaveHospitalBranch {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch1 = new Branch();
		branch1.setName("Bejai");
		branch1.setPhone(9986656);
		branch1.setState("Karnataka");
		branch1.setCountry("IND");
		
		Branch branch2 = new Branch();
		branch2.setName("Malleshwaram");
		branch2.setPhone(78465);
		branch2.setState("Karnataka");
		branch2.setCountry("IND");
		
		Hospital hospital = new Hospital();
		hospital.setName("Rainbow");
		hospital.setWeb("www.rainbow.com");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
}
