package com.konar.demo.rest;

import com.konar.demo.entity.Employee;
import com.konar.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("No employee found with id - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmp = employeeService.findById(employeeId);

        if(tempEmp == null) {
            throw new RuntimeException("No employee found with id - " + employeeId);
        }

        employeeService.delete(employeeId);
        return "employee deleted with id - " + employeeId;
    }


}
