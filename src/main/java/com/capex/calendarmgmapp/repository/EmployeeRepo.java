package com.capex.calendarmgmapp.repository;

import com.capex.calendarmgmapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {


    Employee findByEmailId(String emailid);
}
