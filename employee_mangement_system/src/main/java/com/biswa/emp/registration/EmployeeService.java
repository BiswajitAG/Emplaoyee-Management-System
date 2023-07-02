package com.biswa.emp.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;
@Service
public interface EmployeeService {

	ResponseEntity<Object> saveEmp(Employee employee);

	ResponseEntity<Object> findAllEmp();

	ResponseEntity<Object> findAllEmpWithAddress(int emp_id);


}
