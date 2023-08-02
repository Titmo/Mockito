package com.example.Mockito.service;

import com.example.Mockito.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addPerson(String name, String lastName, int salary, int department);

    Employee deletePerson(String name, String lastName);

    Employee findPerson(String name, String lastName);

    List<Employee> showAllPersons();
}

