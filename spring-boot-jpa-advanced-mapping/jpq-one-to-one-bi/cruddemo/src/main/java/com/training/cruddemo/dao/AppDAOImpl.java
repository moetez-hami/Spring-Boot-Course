package com.training.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.training.cruddemo.entity.Instructor;
import com.training.cruddemo.entity.InstructorDetail;

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

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class,theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		
		// retrieve instructor detail
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		// remove the associated abject reference
		// break bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null); 
		
		// delete the instructor detail
		entityManager.remove(tempInstructorDetail);
		
	}

}
