package com.biswa.emp.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveEmp(@RequestBody Employee employee) {
		return employeeService.saveEmp(employee) ;
		
	}
	@GetMapping("/findAllEmp")
	public ResponseEntity<Object> findAllEmp() {
		return employeeService.findAllEmp() ;
	}
	
	@GetMapping("/findAllEmpWithAddress/{emp_id}")
	public ResponseEntity<Object> findAllEmpWithAddress(@PathVariable int emp_id) {
		return employeeService.findAllEmpWithAddress(emp_id) ;
	}
}
	


