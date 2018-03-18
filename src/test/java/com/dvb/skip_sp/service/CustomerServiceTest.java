package com.dvb.skip_sp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.skip_sp.exception.EmailExistsException;
import com.dvb.skip_sp.model.Customer;
import com.dvb.skip_sp.repository.CustomerRepository;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@TestConfiguration
	static class CustomerServiceTestContextConfiguration {

		@Bean
		public CustomerService customerService() {
			return new CustomerService();
		}
	}

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test(expected = EmailExistsException.class)
	public void shouldShowExceptionIfEmailExists() {
		Customer customer1 = new Customer("daniel@gmail.com", "Daniel", "Address", "123456");
		Customer customer2 = new Customer("daniel@gmail.com", "Daniel2", "Address2", "123");

		Mockito.when(customerRepository.findByEmail(customer2.getEmail())).thenReturn(customer1);

		customerService.IsEmailExists(customer2.getEmail());
	}

	@Test
	public void shouldVerifyThatEmailNoExist() {
		Customer customer1 = new Customer("daniel1@gmail.com", "Daniel1", "Address", "123456");

		Mockito.when(customerRepository.findByEmail(customer1.getEmail())).thenReturn(null);

		Boolean exists = customerService.IsEmailExists(customer1.getEmail());

		Assert.assertTrue(exists);
	}
}
