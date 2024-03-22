package com.training.cruddemo.dao;

import java.util.List;

import com.training.cruddemo.entity.Course;
import com.training.cruddemo.entity.Instructor;
import com.training.cruddemo.entity.InstructorDetail;
import com.training.cruddemo.entity.Student;

public interface AppDAO {
	

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCoursesByInstructorId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void updateCourse(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course theCourse);
	
	Course findCourseAndReviews(int theId);
	
	Course findCourseAndStudentsByCourseId(int theId);
	
	Student findStudentAndCoursesByStudentId(int theId);
	
	void update(Student tempStudent);
	
	void deleteStudentById(int theId);
}
