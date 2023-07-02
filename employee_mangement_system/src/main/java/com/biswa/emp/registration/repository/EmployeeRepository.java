package com.biswa.emp.registration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biswa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
	@Autowired
	EmployeeDAO employeeDAO; 
	
	@Autowired
	EntityManager entityManager;

	public Employee loginEmpData(Employee employee) {
		
		return employeeDAO.findByMailidAndPassword(employee.getMailid(),employee.getPassword());
	}

	public String changePassword(int id, String newPwd) {
		String SQL = "update employee set password='" + newPwd + "' where id=" +id;
		int count=entityManager.createNativeQuery(SQL).executeUpdate();

		if (count > 0)
			return "success";
		else
			return " ";
	}


}
