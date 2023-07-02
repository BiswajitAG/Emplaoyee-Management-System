package com.biswa.emp.address;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.entity.Address;

@Service
public interface AddressService {

	ResponseEntity<Object> saveAddress(Address address, String emp_id);

}
