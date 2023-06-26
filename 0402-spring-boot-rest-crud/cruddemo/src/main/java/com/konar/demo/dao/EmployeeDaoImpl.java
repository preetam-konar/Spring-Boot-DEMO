package com.konar.demo.dao;

import com.konar.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findALl() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(dbEmployee);
    }
}
