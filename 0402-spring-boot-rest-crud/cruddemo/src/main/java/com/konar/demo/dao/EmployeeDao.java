package com.konar.demo.dao;

import com.konar.demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findALl();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);

}
