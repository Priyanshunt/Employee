package com.springboot.demo.employee.model;

public class EmployeeResponse {

    private int status;
    private String message;
    private long timeStamp;
    private String name;
    private String department;
    private String machine;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String message) {
        this.status = 200;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public EmployeeResponse(String message, Employee employee) {
        this(message);
        this.name = employee.getName();
        this.department = employee.getDepartment();
        this.machine = employee.getMachine();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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
