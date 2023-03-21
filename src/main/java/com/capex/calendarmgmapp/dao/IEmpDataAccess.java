package com.capex.calendarmgmapp.dao;

import com.capex.calendarmgmapp.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmpDataAccess {
    void addEmployee(String name, String email, String location);
    void removeEmployee(String emailid);

    Employee getEmployee(String emailid);

    List<Employee> getAllEmployees();

    void updateEmpDetails(String emailid,Employee newDets);


}
