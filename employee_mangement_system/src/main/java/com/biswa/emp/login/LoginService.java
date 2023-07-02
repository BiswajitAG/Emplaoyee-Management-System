package com.biswa.emp.login;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.entity.Employee;

@Service
public interface LoginService {

	ResponseEntity<Object> loginEmp(Employee employee);

	ResponseEntity<Object> forgotPasswordEmp(String mail);

	ResponseEntity<Object> changePassword(Employee employee, String newPwd);


}
