package com.springboot.practice.controller;

import com.springboot.practice.model.Employee;
import com.springboot.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Employee> fetchEmployee(@PathVariable Long id){

        Employee employee=employeeService.fetchEmployee(id);

        if(employee==null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){

        String response=employeeService.addEmployee(employee);
        if("alreadyexist".equals(response)){
            return new ResponseEntity<>("Employee Already Exist",HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Employee Created",HttpStatus.CREATED);
    }



    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@RequestParam Long id){

       String response= employeeService.deleteEmployee(id);
        if("notfound".equals(response)){
            return new ResponseEntity<>("Employee Does not Exist",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Employee Deleted",HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){

        String response=employeeService.updateEmployee(employee);
        if("updated".equals(response)){
            return new ResponseEntity<>("Employee Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee Created",HttpStatus.OK);
    }




}
