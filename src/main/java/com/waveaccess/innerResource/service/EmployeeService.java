package com.waveaccess.innerResource.service;

import com.waveaccess.innerResource.entity.Employee;
import com.waveaccess.innerResource.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {

        String firstname = employee.getFirstname();
        String lastname = employee.getLastname();
        String middlename = employee.getMiddlename();
        Integer age = employee.getAge();
        String email = employee.getEmail();
        String employeePosition = employee.getEmployeePosition();
        String username = employee.getUsername();
        String password = employee.getPassword();

        if (!firstname.isEmpty() && !lastname.isEmpty() && !middlename.isEmpty()) {

            if (employeeRepository.findByEmail(email).isPresent()) {

                Employee newEmployee = new Employee(firstname, lastname, middlename, age, email,
                        employeePosition, username, password);
                employeeRepository.save(newEmployee);
            }
        }
    }
}

