package com.springboot.demo.employee.dao;

import com.springboot.demo.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.merge(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery(
                "delete from Employee where id=:employeeId");

        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
