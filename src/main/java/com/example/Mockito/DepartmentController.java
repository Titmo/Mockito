package com.example.Mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/employees")

    public Map<Integer, List<Employee>> getEmployee() {
        return departmentService.showAllDepartmot();
    }
    @GetMapping("/{id}/employees")
    public ArrayList<Employee> getDepartmentId(@PathVariable int id) {
        return departmentService.listOfDepartment(id);
    }
    @GetMapping("/{id}/salary/max")
    public Employee maxSalary(@PathVariable int id) {
        return departmentService.maxSalary(id);
    }
    @GetMapping("/{id}/salary/min")
    public Employee minSalary(@PathVariable int id) {
        return departmentService.mixSalary(id);
    }
    @GetMapping("/{id}/salary/sum")
    public int sumSalary(@PathVariable int id) {
        return departmentService.sumSalary(id);
    }

}
