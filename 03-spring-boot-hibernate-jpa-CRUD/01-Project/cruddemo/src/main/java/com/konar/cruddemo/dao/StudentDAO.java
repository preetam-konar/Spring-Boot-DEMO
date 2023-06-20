package com.konar.cruddemo.dao;


import java.util.List;

import com.konar.cruddemo.entity.Student;

public interface StudentDAO {

    void save (Student student);

    Student findStudentById(Integer id);

    List<Student> findAllStudents();

    List<Student> findStudentsByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudent(int id);

    int deleteAll();
}
