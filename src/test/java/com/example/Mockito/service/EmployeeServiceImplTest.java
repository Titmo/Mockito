package com.example.Mockito.service;

import com.example.Mockito.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeServiceImpl employeeService;

    List<Employee> staff = new ArrayList<>(List.of());

    public EmployeeServiceImplTest(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Чернов", "Данила", 90_000, 1);
        Employee employee2 = new Employee("Григорьев", "Олег", 60_000, 2);
        Employee employee3 = new Employee("Беляев", "Максим", 80_000, 1);
        Employee employee4 = new Employee("Александров", "Кирилл", 99_000, 3);
        staff.add(employee1);
        staff.add(employee2);
        staff.add(employee3);
        staff.add(employee4);
    }

    @Test
    void addPerson() {
        String name = "Ivan";
        String lastName = "Ivanov";
        int salary = 120000;
        int department = 1;

        Employee act = employeeService.addPerson(name,lastName,salary,department);

        Employee employee = new Employee("Ivan", "Ivanov", 120000, 1);
        staff.add(employee);
        Employee ex= staff.get(staff.indexOf(employee));

        assertEquals(act,ex);
    }

    @Test
    void deletePerson() {
    }

    @Test
    void findPerson() {
    }

    @Test
    void showAllPersons() {
    }
}