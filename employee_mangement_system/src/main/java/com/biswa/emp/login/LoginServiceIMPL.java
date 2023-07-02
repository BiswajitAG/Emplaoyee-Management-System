package com.biswa.emp.login;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.emp.common.SendMailService;
import com.biswa.emp.registration.repository.EmployeeDAO;
import com.biswa.emp.registration.repository.EmployeeRepository;
import com.biswa.entity.Employee;

@Service
public class LoginServiceIMPL implements LoginService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	SendMailService sendMailService;
	
	@Override
	public ResponseEntity<Object> loginEmp(Employee employee) {
		Map<String,Object> response= new LinkedHashMap<>();
		Employee loginEmpData=employeeRepository.loginEmpData(employee);
		if (loginEmpData==null) {
			response.put("status", "Error");
			response.put("message", "Invalide UserName/password");
		}
		else {
			response.put("status", "ok");
			response.put("data", loginEmpData);
		}	
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> forgotPasswordEmp(String mail) {
		Map<String,Object> response= new LinkedHashMap<>();
		List<Employee> listEmp =employeeDAO.findByMailid(mail);
		if (listEmp.size()==0) {
			response.put("status", "Error");
			response.put("message", "MailId doesn't esist ");
			
		}
		else {
			sendMailService.sendEmail(listEmp.get(0), "forgot");
			response.put("status", "ok");
			response.put("message", "password send sucessfully to your mail "+listEmp.get(0).getMailid());
		}
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> changePassword(Employee employee, String newPwd) {
		Map<String,Object> response= new LinkedHashMap<>();
		Employee loginEmpData=employeeRepository.loginEmpData(employee);
		if (loginEmpData==null) {
			response.put("status", "Error");
			response.put("message", "Invalide UserName/password,you can resate the passwod");
		}
		else {
			String msg= employeeRepository.changePassword(loginEmpData.getId(),newPwd);
			if(msg.equals("success")) {
			response.put("status", "ok");
			response.put("data", "Password change sucessfully");
		}	
		else {
			response.put("status", "Error");
			response.put("data", "some thing wrong, Try Again");
		}
		}
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}


}
