package com.oumoi.projectmanagement.service;

import com.oumoi.projectmanagement.entities.Employee;
import com.oumoi.projectmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getEmployeeList(){
        Iterable<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }
}
