package com.example.Mockito.service;

import com.example.Mockito.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest {
    DepartmentServiceImpl departmentService;

    List<Employee> staff = new ArrayList<>(List.of());

    private DepartmentServiceImplTest(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
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
    void showAllDepartmot() {
        Map<Integer, List<Employee>> act =departmentService.showAllDepartmot();

        Map<Integer, List<Employee>> ex = staff.stream()
                .collect(groupingBy(Employee::getDepartment));

        assertEquals(act,ex);
    }

    @Test
    void mixSalary() {
        int departmentId = 1;

        Employee act = departmentService.mixSalary(1);
        Employee ex = staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .get();
        assertEquals(act,ex);
    }

    @Test
    void maxSalary() {
        int departmentId = 1;

        Employee act = departmentService.maxSalary(1);
        Employee ex = staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .get();
        assertEquals(act,ex);
    }

    @Test
    void sumSalary() {
        int departmentId = 1;

        int act = departmentService.sumSalary(1);
        int ex = staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .mapToInt(Employee::getSalary).sum();
        assertEquals(act,ex);

    }

    @Test
    void listOfDepartment() {
        int departmentId = 1;

        List<Employee> act = departmentService.listOfDepartment(1);
        List<Employee> ex = staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());
        assertEquals(act,ex);
    }
}