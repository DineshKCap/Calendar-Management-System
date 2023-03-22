package com.capex.calendarmgmapp.service;

import com.capex.calendarmgmapp.dao.EmployeeDAO;
import com.capex.calendarmgmapp.dao.IEmpDataAccess;
import com.capex.calendarmgmapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final IEmpDataAccess employeeDAO;

    @Autowired
    public EmployeeService(IEmpDataAccess employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void add(String name, String email, String location){
        employeeDAO.addEmployee(email,name,location);
    }
    public void remove(String emailId){
        employeeDAO.removeEmployee(emailId);
    }

    public Employee getOne(String emailId){
        return employeeDAO.getEmployee(emailId);
    }

    public List<Employee> getAll(){
        return employeeDAO.getAllEmployees();
    }

    public void update(String emailId,Employee newDets){
        employeeDAO.updateEmpDetails(emailId, newDets);
    }

}
