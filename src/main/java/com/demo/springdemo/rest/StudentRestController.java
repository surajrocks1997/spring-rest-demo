package com.demo.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		Student student1 = new Student("Shalini", "Arora");
		Student student2 = new Student("Mehar", "Malik");
		Student student3 = new Student("Ashu", "Sharma");

		theStudents.add(student1);
		theStudents.add(student2);
		theStudents.add(student3);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not Found - " + studentId);
		}

		return theStudents.get(studentId);
	}

}
