package com.oumoi.projectmanagement.api;


import com.oumoi.projectmanagement.entities.Employee;
import com.oumoi.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmpployeeControllerApi {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public Iterable<Employee> projectList(){
        return employeeService.getEmployeeList();
    }
}
