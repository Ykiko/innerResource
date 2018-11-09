package com.waveaccess.innerResource.controllers;

import com.waveaccess.innerResource.entity.Employee;
import com.waveaccess.innerResource.repository.EmployeeRepository;
import com.waveaccess.innerResource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCrud {

    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeCrud(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String hello(Model model) {
       // model.addAttribute("employees", employeeRepository.findAll());
        return "/";
    }

    @RequestMapping(value = {"/addEmployee"}, method = RequestMethod.GET)
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
       // model.addAttribute("employees", employeeRepository.findAll());
        return "addEmployee";
    }

    @RequestMapping(value = {"/addEmployee"}, method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
