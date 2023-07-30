package com.example.Mockito.service;

import com.example.Mockito.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> showAllDepartmot();
    Employee mixSalary(int departmentId);
    Employee maxSalary(int departmentId);
    int sumSalary(int departmentId);
    List<Employee> listOfDepartment(int departmentId);
}
