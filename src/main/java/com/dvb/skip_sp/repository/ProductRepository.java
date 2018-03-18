package com.dvb.skip_sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.skip_sp.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	public List<Product> findByNameContaining(String name);
	
	public List<Product> findByStoreId(Long storeId);
	
}
