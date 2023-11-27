package com.springboot.demo.employee.repository.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "root")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "department", length = 50)
    private String department;
    @Column(name = "machine", length = 50)
    private String machine;

    public Employee() {
    }

    public Employee(String name, String department, String machine) {
        this.name = name;
        this.department = department;
        this.machine = machine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
