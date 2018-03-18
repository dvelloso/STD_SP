package com.dvb.skip_sp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.skip_sp.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findByName(String name);

	public Customer findByEmail(String email);
}
