package com.dvb.skip_sp.resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dvb.skip_sp.model.Customer;
import com.dvb.skip_sp.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerResource.class)
public class CustomerResourceTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerService customerService;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void shouldPostCustomer() throws Exception {
		Customer customer = new Customer("daniel@gmail.com", "Daniel", "Address", "123456");
		String json = mapper.writeValueAsString(customer);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/Customer").//
				contentType(MediaType.APPLICATION_JSON).content(json).//
				accept(MediaType.APPLICATION_JSON)).//
				andExpect(status().isCreated());
	}
}
