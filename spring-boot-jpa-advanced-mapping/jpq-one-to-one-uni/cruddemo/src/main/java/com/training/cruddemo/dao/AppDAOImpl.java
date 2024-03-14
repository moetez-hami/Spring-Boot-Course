package com.training.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.training.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

	
	// define field for entity manager
	
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		entityManager.persist(theInstructor);
		
	}

	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		// retrieve the instructor 
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		// delete the instructor
		entityManager.remove(tempInstructor);
		
		
	}

}
