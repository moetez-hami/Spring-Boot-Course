package com.training.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

	
	// define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager; 
	}
	
	// implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		// Create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
		// Return query results
		return theQuery.getResultList();
		
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);
		
		// set query parameters
		theQuery.setParameter("theData", theLastName);
		
		// return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		
		entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		// retreive teh student
		Student  theStudent = entityManager.find(Student.class, id);
		
		// delete the student
		entityManager.remove(theStudent);
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	} 

}
