package com.springboot.demo.employee.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "machine")
    private String machine;

    public Employee() {
    }

    public Employee(String name, String department, String machine) {
        this.name = name;
        this.department = department;
        this.machine = machine;
    }

    public Employee(Integer id, String name, String department, String machine) {
        this.id = id;
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
