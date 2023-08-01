package com.example.Mockito.service;

import com.example.Mockito.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> showAllDepartmot() {
        return employeeService.showAllPersons().stream()
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee mixSalary(int departmentId) {
        return employeeService.showAllPersons().stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return employeeService.showAllPersons().stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }
    @Override
    public int sumSalary(int departmentId) {
        return employeeService.showAllPersons().stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .mapToInt(Employee::getSalary).sum();
    }
    @Override
    public List<Employee> listOfDepartment(int departmentId) {
        return  employeeService.showAllPersons()
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());
    }
}