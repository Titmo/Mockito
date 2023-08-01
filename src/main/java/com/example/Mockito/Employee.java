package com.example.Mockito;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(Name, employee.Name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, lastName, salary, department);
    }
}
