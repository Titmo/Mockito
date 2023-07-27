package com.example.Mockito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addPerson(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam int salary,
                              @RequestParam int department) {
        return employeeService.addPerson(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/get")
    public Employee findPerson(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findPerson(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deletePerson(firstName, lastName);
    }
    @GetMapping(path = "/getAll")
    public List<Employee> showAllPersons() {
        return employeeService.showAllPersons();
    }
}