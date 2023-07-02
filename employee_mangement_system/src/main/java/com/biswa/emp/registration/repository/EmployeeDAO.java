package com.biswa.emp.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entity.Address;
import com.biswa.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

	List<Employee> findByMailidAndMobile(String mailid,String mobile);

	Employee findByMailidAndPassword(String mailid, String password);

	List<Employee> findByMailid(String mail);





}

