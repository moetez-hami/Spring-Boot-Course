package com.training.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the student data ... only once!
	
	@PostConstruct
	public void loadData() {
		
		theStudents =new ArrayList<>();
		
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Mario","Rossi"));
		theStudents.add(new Student("Mary","Smith"));
	}

	// define endpoint for "/student" -return list of students

	@GetMapping("/students")
	public List<Student> getStudent(){
		
		return theStudents;
	}
	
	// define endpoint or "/students/{studentId}" -return student at index
	
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
	
		// just index into the list ... keep it simple for now
		
		// check the student again list size
		
		if((studentId >= theStudents.size()) ||(studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return theStudents.get(studentId);
	}
	
	
	
}
