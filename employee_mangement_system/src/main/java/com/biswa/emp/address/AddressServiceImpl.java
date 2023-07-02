package com.biswa.emp.address;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswa.emp.registration.repository.EmployeeRepository;
import com.biswa.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDAO addressDAO;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public ResponseEntity<Object> saveAddress(Address address, String emp_id) {
		Map<String, Object> response = new LinkedHashMap<>();
		if (address != null) {
			addressDAO.save(address);
			int add_id = address.getId();
			boolean isUpdate = addressRepository.updateAddressIdInEmployee(emp_id, add_id);
			if (isUpdate) {
				response.put("status", "OK");
				response.put("message", "Address Created Successfulluy with ID - " + emp_id);
			} else {
				response.put("status", "ERROR");
				response.put("message", "Something wrong");
			}
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
