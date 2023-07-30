package com.example.Mockito.service;

import com.example.Mockito.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTestMockito {
    public DepartmentServiceTestMockito(DepartmentServiceImpl departmentService, EmployeeServiceImpl employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private EmployeeServiceImpl employeeService;

    @Test
    void withMaxSalary_success() {
        int departmentId1 = 1;
        int departmentId2 = 2;
        List<Employee> employees = new ArrayList<>(List.of());
        Employee employee1 = new Employee("Чернов", "Данила", 90_000, 1);
        Employee employee2 = new Employee("Григорьев", "Олег", 60_000, 2);
        Employee employee3 = new Employee("Беляев", "Максим", 80_000, 1);
        Employee employee4 = new Employee("Александров", "Кирилл", 99_000, 3);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


        when(employeeService.showAllPersons()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        Employee expectedMaxSalary = employees.stream()
                .filter(d -> (d.getDepartment() == departmentId1))
                .max(Comparator.comparing(Employee::getSalary))
                .get();


        Employee actualMaxSalary = departmentService.maxSalary(departmentId1);
        assertEquals(expectedMaxSalary, actualMaxSalary);
        assertNotEquals(departmentId1, departmentId2);
        verify(employeeService).showAllPersons();
        verifyNoMoreInteractions(employeeService);
    }

}
