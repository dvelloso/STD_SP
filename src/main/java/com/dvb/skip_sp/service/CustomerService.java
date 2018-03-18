package com.dvb.skip_sp.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvb.skip_sp.exception.EmailExistsException;
import com.dvb.skip_sp.model.Customer;
import com.dvb.skip_sp.repository.CustomerRepository;

@Service
public class CustomerService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6197951840474181167L;
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	public Optional<Customer> findByCustomer(Long id) {
		return customerRepository.findById(id);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public Boolean IsEmailExists(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if (customer == null) {
			return true;
		}

		throw new EmailExistsException();
	}

}
