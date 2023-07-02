package com.biswa.emp.address;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswa.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Integer>{
	

}
