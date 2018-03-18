package com.dvb.skip_sp.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.skip_sp.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void shouldReturnCustomerByName() {
		Customer customer = new Customer("daniel@gmail.com", "Daniel", "Address", "123456");
		entityManager.persist(customer);
		entityManager.flush();

		Customer found = customerRepository.findByName("Daniel");
		Assert.assertEquals("Daniel", found.getName());
	}

	@Test
	public void shouldReturnCustomerById() {
		Customer customer = new Customer("daniel@gmail.com", "Daniel", "Address", "123456");
		entityManager.persist(customer);
		entityManager.flush();

		Optional<Customer> found = customerRepository.findById(customer.getId());
		Assert.assertEquals(customer.getId(), found.get().getId());
	}

	
}
