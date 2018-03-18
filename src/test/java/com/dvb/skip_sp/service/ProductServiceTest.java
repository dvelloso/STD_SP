package com.dvb.skip_sp.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.skip_sp.exception.NoProductFoundWithThisFilterException;
import com.dvb.skip_sp.model.Product;
import com.dvb.skip_sp.repository.ProductRepository;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
	
	@TestConfiguration
	static class ProductServiceTestContextConfiguration {

		@Bean
		public ProductService productService() {
			return new ProductService();
		}
	}
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test(expected = NoProductFoundWithThisFilterException.class)
	public void shouldShowExceptionIfTheresNoProductIntoFilter() {
		Mockito.when(productRepository.findByNameContaining("no product")).thenReturn(null);
		
		List<Product> products = productService.findByNameContaining("no product");
	}
	
	@Test
	public void shouldReturListOfProductsThatContainTheFilter() {
		List<Product> products = Arrays.asList(new Product(1L, "Japanese 1", "", new BigDecimal("10")), //
				new Product(2L, "Japanese drinks", "", new BigDecimal("5")), //)
				new Product(3L, "Japanese drinks", "", new BigDecimal("5")));
		
		Mockito.when(productRepository.findByNameContaining("Japa")).thenReturn(products);
		
		List<Product> founds = productService.findByNameContaining("Japa");
		
		Assert.assertEquals(3L, founds.size());
	}

}
