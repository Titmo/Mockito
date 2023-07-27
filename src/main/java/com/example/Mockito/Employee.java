package com.example.Mockito;

public class Employee {
    private String Name;
    private String lastName;
    private int salary;
    private int department;

    public Employee(String name, String lastName, int salary, int department) {
        Name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }
}
