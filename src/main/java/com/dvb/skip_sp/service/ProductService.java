package com.dvb.skip_sp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvb.skip_sp.exception.NoProductFoundWithThisFilterException;
import com.dvb.skip_sp.model.Product;
import com.dvb.skip_sp.repository.ProductRepository;

@Service
public class ProductService implements Serializable {

	private static final long serialVersionUID = 4421971273960121426L;

	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> findByNameContaining(String name) {
		List<Product> founds = productRepository.findByNameContaining(name);
		if (founds == null) {
			throw new NoProductFoundWithThisFilterException();
		}

		return founds;
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	public List<Product> findByStoreId(Long storeId) {
		return productRepository.findByStoreId(storeId);
	}

}
