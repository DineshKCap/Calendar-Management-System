package com.capex.calendarmgmapp.dao;

import com.capex.calendarmgmapp.model.Employee;
import com.capex.calendarmgmapp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO implements IEmpDataAccess{


    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeDAO(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void addEmployee(String name, String emailId, String location) {
        Employee newEmployee = new Employee(name, emailId, location);
        employeeRepo.save(newEmployee);
    }

    @Override
    public void removeEmployee(String emailId) {
        Employee curEmployee = employeeRepo.findByEmailId(emailId);
        employeeRepo.delete(curEmployee);
    }

    @Override
    public Employee getEmployee(String emailId) {
        Employee curEmployee = employeeRepo.findByEmailId(emailId);
//        return new ResponseEntity<>(curEmployee,HttpStatus.OK);
        return curEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {

//        return new ResponseEntity<>((List<Employee>) employeeRepo.findAll(),HttpStatus.OK);
        return (List<Employee>) employeeRepo.findAll();
//        return null;
    }

    @Override
    public void updateEmpDetails(String emailId, Employee newDets) {
        Employee curEmployee = employeeRepo.findByEmailId(emailId);

        curEmployee.setEmailId(newDets.getEmailId());
        curEmployee.setName(newDets.getName());
        curEmployee.setLocation(newDets.getLocation());

        employeeRepo.save(curEmployee);
    }
}
