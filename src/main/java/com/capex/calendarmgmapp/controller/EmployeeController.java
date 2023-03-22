package com.capex.calendarmgmapp.controller;

import com.capex.calendarmgmapp.model.Employee;
import com.capex.calendarmgmapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping(path = "/add")
    void addEmployee(@RequestParam("name") String name,@RequestParam("emailId") String emailId,@RequestParam("location") String location){
        employeeService.add(emailId, name, location);
    }

    @DeleteMapping(path = "/del")
    void removeEmployee(@RequestParam("emailId") String emailId)
    {
        employeeService.remove(emailId);
    }

    @GetMapping(path = "/justOne")
    ResponseEntity<Employee> getEmployee(@RequestParam("emailId") String emailId)
    {
        return new ResponseEntity<>(employeeService.getOne(emailId), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    ResponseEntity<List<Employee>> getAllEmployees(){

        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    void updateEmpDetails(@RequestParam("emailId") String emailId,@RequestBody Employee newDets){
        employeeService.update(emailId, newDets);
    }



}
