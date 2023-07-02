package com.biswa.emp.registration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.emp.address.AddressDAO;
import com.biswa.emp.common.GeneratePasswordService;
import com.biswa.emp.common.SendMailService;
import com.biswa.emp.registration.repository.EmployeeDAO;
import com.biswa.entity.Address;
import com.biswa.entity.Employee;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeServicesImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	AddressDAO addressDAO;
	
	@Autowired
	GeneratePasswordService generatePasswordService;
	
	@Autowired
	SendMailService sendMailService;

	@Override
	public ResponseEntity<Object> saveEmp(Employee employee) {

		Map<String, Object> response = new LinkedHashMap<>();
		List<Employee> emp = employeeDAO.findByMailidAndMobile(employee.getMailid(),employee.getMobile());
		if (emp.size() > 0) {
			response.put("Status", "Error");
			response.put("Message", "Data is allready exist");
		} else {
			employee.setPassword(generatePasswordService.generatePassword());
			employeeDAO.save(employee);
			sendMailService.sendEmail(employee,"save");
			response.put("Status", "ok");
			response.put("Message", "Data Inserted sucessfully. cheak your mail for password");
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findAllEmp() {
		Map<String, Object> response=new LinkedHashMap<>();
		List<Employee> listEmpData=employeeDAO.findAll();
		if (listEmpData.isEmpty()) {
			response.put("status", "Sorry");
			response.put("message", "No data found");	
		}
		else {
			response.put("ststus", "ok");
			response.put("count", listEmpData.size());

			response.put("message", listEmpData);

		}
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findAllEmpWithAddress(int emp_id) {
		Map<String, Object> response=new LinkedHashMap<>();
		Optional<Employee> employee=employeeDAO.findById(emp_id);
		Optional<Address> address = addressDAO.findById(employee.get().getAddressid());
		response.put("ststus", "ok");
		response.put("Emp_id",emp_id);
		response.put("Employee",employee);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

}
