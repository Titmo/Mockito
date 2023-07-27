package com.example.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> showAllDepartmot();
    Employee mixSalary(int departmentId);
    Employee maxSalary(int departmentId);
    int sumSalary(int departmentId);
    ArrayList<Employee> listOfDepartment(int departmentId);
}
