package com.springboot.practice.service;

import com.springboot.practice.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Employee fetchEmployee(Long id);

    public String addEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(Long id);

}
