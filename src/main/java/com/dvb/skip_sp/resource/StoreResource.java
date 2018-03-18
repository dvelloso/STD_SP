package com.dvb.skip_sp.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvb.skip_sp.model.Product;
import com.dvb.skip_sp.model.Store;
import com.dvb.skip_sp.service.ProductService;
import com.dvb.skip_sp.service.StoreService;

@RestController
@RequestMapping("/api/v1/Store")
public class StoreResource implements Serializable{
	
	private static final long serialVersionUID = 7076777481804388156L;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Store>> getStore() {
		List<Store> stores = storeService.findAll();

		if (stores.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/search/{searchText}")
	public ResponseEntity<List<Store>> getStoretText(@PathVariable("searchText") String searchText) {
		List<Store> stores = storeService.findByNameContaining(searchText);

		if (stores.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/{storeId}")
	public ResponseEntity<Store> getProductById(@PathVariable("storeId") Long id) {
		Optional<Store> stores = storeService.findById(id);

		if (!stores.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Store>(stores.get(), HttpStatus.OK);
	}
	
	@GetMapping("/{storeId}/products")
	public ResponseEntity<List<Product>> getProducByStoreId(@PathVariable("storeId") Long storeId) {
		List<Product> products = productService.findByStoreId(storeId);

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
