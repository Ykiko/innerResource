package com.waveaccess.innerResource.repository;

import com.waveaccess.innerResource.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

}
