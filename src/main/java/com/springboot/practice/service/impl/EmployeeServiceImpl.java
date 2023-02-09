package com.springboot.practice.service.impl;

import com.springboot.practice.entity.EmployeeEntity;
import com.springboot.practice.model.Employee;
import com.springboot.practice.repository.EmployeeRepository;
import com.springboot.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    private Map<Long,Employee> employeeMap=new HashMap<>();

    @Override
    public Employee fetchEmployee(Long id) {
        return employeeMap.get(id);
    }

    @Override
    public String addEmployee(Employee employee) {

        employeeRepository.save(new EmployeeEntity("rakesh",1L,"backend",20,120000L));
        employeeRepository.save(new EmployeeEntity("akash",3L,"frontend",40,12000L));
        employeeRepository.save(new EmployeeEntity("nakshatra",4L,"backend",10,1200L));
        employeeRepository.save(new EmployeeEntity("bala",2L,"frontend",30,1200000L));

        if(employeeMap.containsKey(employee.getId())){
            return "alreadyexist";
        }
        employeeMap.put(employee.getId(),employee);
        return "employecreated";
    }

    @Override
    public String updateEmployee(Employee employee) {
        if(employeeMap.containsKey(employee.getId())){
            employeeMap.put(employee.getId(),employee);
            return "updated";
        }

        employeeMap.put(employee.getId(),employee);
        return "created";
    }

    @Override
    public String deleteEmployee(Long id) {
        if(!employeeMap.containsKey(id)){
            return "notfound";
        }
        employeeMap.remove(id);

        return "deleted";
    }
}
