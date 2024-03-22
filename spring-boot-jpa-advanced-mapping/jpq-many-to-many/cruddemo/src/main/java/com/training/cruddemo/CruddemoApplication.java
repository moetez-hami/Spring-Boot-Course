package com.training.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.cruddemo.dao.AppDAO;
import com.training.cruddemo.entity.Course;
import com.training.cruddemo.entity.Instructor;
import com.training.cruddemo.entity.InstructorDetail;
import com.training.cruddemo.entity.Review;
import com.training.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createCourseAndStudents(appDAO);
			
			// findCourseAndStudents(appDAO);
			
			// findStudentAndCourses(appDAO);
			
			// addMoreCoursesForStudent(appDAO);
			
			// deleteCourse(appDAO);
			
			deleteStudent(appDAO);
			
			
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=2;
		System.out.println("Deleting student id: "+theId);
		
		appDAO.deleteStudentById(theId);
		System.out.println("Done");
		
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=2;
		Student tempStudent =appDAO.findStudentAndCoursesByStudentId(theId);
		
		// create more courses
		Course tempCourse1 =new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 =new Course("Atari  2600 - Game development");
		
		//add course to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		
		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		
		System.out.println("Done");
		
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=1;
		
		Student tempStudent =appDAO.findStudentAndCoursesByStudentId(theId);
		
		System.out.println("Loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		System.out.println("Done");
		
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=10;
		Course tempCourse =appDAO.findCourseAndStudentsByCourseId(theId);
		
		System.out.println("Loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		System.out.println("Done");
		
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// create a course
		Course tempCourse =new Course("Pacman - How To Score One Million Points");
		
		// create the students
		Student tempStudent1 = new Student("john","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		
		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		// save the course and associated students
		System.out.println("Saving the course "+tempCourse);
		System.out.println("associated students "+tempCourse.getStudents());
		
		appDAO.save(tempCourse);
		
		System.out.println("Done");
		
		
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=10;
		
		System.out.println("Deleting course id :"+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
		
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// get the course and reviews
		int theId =10;
		Course tempCourse =appDAO.findCourseAndReviews(theId);
		
		// print the course
		System.out.println(tempCourse);
		
		// print the reviews
		System.out.println(tempCourse.getReviews());
		
		System.out.println("Done");
		
	}

	private void CreateCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// create a course
		Course tempCourse = new Course("Pacman - How to score one million points");
		
		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
		
		// save the course
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDAO.save(tempCourse);
		
		System.out.println("Done");
		
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=10;
		
		System.out.println("Deleting Course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done");
		
	}

	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId =10;
		
		// find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse=appDAO.findCourseById(theId);
		
		// update the course
		System.out.println("Updating couser id: "+theId);
		tempCourse.setTitle("Enjoy the simple Things");
		
		appDAO.updateCourse(tempCourse);
		System.out.println("Done");
		
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		
		// find the instructor
		System.out.println("Finding instructor id : "+theId);
		Instructor tempInstructor= appDAO.findInstructorById(theId);
		
		// update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("TESTER");
		
		appDAO.update(tempInstructor);
		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		
		// find the instructor
		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor =appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId =1;
		System.out.println("Fiding instructor id: "+theId);
		
		Instructor tempInstructor =appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		
		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses =appDAO.findCoursesByInstructorId(theId);
		
		// associate the objects
		tempInstructor.setCourses(courses);
		
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done !");		
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId =1;
		System.out.println("Fiding instructor id: "+theId);
		
		Instructor tempInstructor =appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// create the instructor
		
				Instructor tempInstructor = new Instructor("Susan","Public","susan@luv2code.com");
				
				// create the instructor detail
				
				InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");
				
				
				// associate the objects
				tempInstructor.setInstructorDetail(tempInstructorDetail);
				
				// create some courses
				Course tempCourse1 =new Course("Air Guitar - The Ultimate Guide");
				Course tempCourse2 =new Course("Air Pinball Masterclass");
				
				// add courses to instructor
				tempInstructor.add(tempCourse1);
				tempInstructor.add(tempCourse2);
				
				// save the instructor
				// NOTE: this will Also save the courses
				// because of CascadeType.PERSIST
				System.out.println("Save instructor: "+tempInstructor);
				System.out.println("The courses: "+tempInstructor.getCourses());
				appDAO.save(tempInstructor);
				
				System.out.println("Done !");
				
		
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=3;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		
		System.out.println("Done");
		
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		// print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		
		// print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());
		
		System.out.println("Done");
		
	}

	
	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done !");
		
	}
	
	
	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("Finding instructor id:"+ theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
		
	}

	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		/*// create the instructor
		
		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
		
		// create the instructor detail
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 Code !!!");*/
		
		// create the instructor
		
		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
		
		// create the instructor detail
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Guitar");
		
		
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		// save the instructor
		// NOTE: this will ALSO save details object
		// because of CascadeType.ALL
		
		System.out.println("Saving Instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
		
	}

}
