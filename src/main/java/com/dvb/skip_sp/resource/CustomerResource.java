package com.dvb.skip_sp.resource;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dvb.skip_sp.model.Customer;
import com.dvb.skip_sp.service.CustomerService;

@RestController
public class CustomerResource implements Serializable{


	private static final long serialVersionUID = 8443646514753428375L;
	
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/api/v1/Customer")
	public ResponseEntity<Customer> save(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
		customerService.save(customer);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/api/v1/Customer/{id}").buildAndExpand(customer.getId()).toUri());

		return new ResponseEntity<Customer>(header, HttpStatus.CREATED);
	}

}
