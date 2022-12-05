package com.oumoi.projectmanagement.controllers;


import com.oumoi.projectmanagement.entities.Employee;
import com.oumoi.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String employeesListPage(){
        return "employees/employee_list";
    }

    @GetMapping("/new-employee")
    public String newEmployeePage(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/new_employee";
    }

    @PostMapping("/create")
    public String newEmployee(@ModelAttribute("employee") Employee employee, Model model,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            model.addAttribute("employee", employee);
            redirectAttributes.addFlashAttribute("error","Failed to create new employee");
            return "employees/new_employee";
        }
        employeeService.createEmployee(employee);
        redirectAttributes.addFlashAttribute("success","Successfully create new Employee "+employee.getFirstname());
        return "redirect:/employees";
    }
}
