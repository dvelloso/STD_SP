package com.dvb.skip_sp.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.skip_sp.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void shouldReturnProductsContainingJapa(){
		List<Product> products = Arrays.asList(new Product(1L, "Japanese food", "", new BigDecimal("10")), //
				new Product(2L, "Japanesse drinks", "", new BigDecimal("5")), //
				new Product(3L, "Brazilian food", "", new BigDecimal("20")));
		
		products.stream().forEach(p -> entityManager.persist(p));
		entityManager.flush();
		
		List<Product> founds = productRepository.findByNameContaining("Japa");
		Assert.assertEquals(2L, founds.size());
	}

}
