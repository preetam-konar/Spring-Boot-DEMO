package com.konar.cruddemo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.konar.cruddemo.dao.StudentDAO;
import com.konar.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students.");
		int num = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + num);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		studentDAO.deleteStudent(2);

	}

	private void updateStudent(StudentDAO studentDAO) {
		Student tempStudent = studentDAO.findStudentById(1);
		tempStudent.setFirstName("nothing");

		studentDAO.updateStudent(tempStudent);

		Student updatedStudent = studentDAO.findStudentById(1);

		System.out.println(updatedStudent);

	}

	private void readByLastName(StudentDAO studentDAO) {
		ArrayList<Student> studentList = (ArrayList<Student>) studentDAO.findStudentsByLastName("b");
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {

		ArrayList<Student> studentList = (ArrayList<Student>) studentDAO.findAllStudents();
		for (Student student : studentList) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("a", "b", "c");
		studentDAO.save(tempStudent);

		Integer id = tempStudent.getId();
		Student fStudent = studentDAO.findStudentById(tempStudent.getId());

		System.out.println("Found student: " + fStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating student...");
		Student tempStudent = new Student("x", "y", "z");

		System.out.println("Saving student to db...");
		studentDAO.save(tempStudent);

		System.out.println("Student saved, generated id: " + tempStudent.getId());
	}

}
