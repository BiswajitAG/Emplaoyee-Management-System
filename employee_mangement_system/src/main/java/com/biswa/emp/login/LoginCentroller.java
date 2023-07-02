package com.biswa.emp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biswa.entity.Employee;

@RestController
@RequestMapping("/emp")
public class LoginCentroller {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/loginEmp")
	public ResponseEntity<Object> loginEmp(@RequestBody Employee employee){
		return loginService.loginEmp(employee);
		
	}
	@GetMapping("/forgotPasswordEmp/{mail}")
	public ResponseEntity<Object> forgotPasswordEmp(@PathVariable String mail){
		return loginService.forgotPasswordEmp(mail);
}
	@PutMapping("/changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody Employee employee, @RequestParam String newPwd){
		return loginService.changePassword(employee, newPwd);
		
	}

	
}
