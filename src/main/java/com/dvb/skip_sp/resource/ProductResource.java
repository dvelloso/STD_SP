package com.dvb.skip_sp.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dvb.skip_sp.model.Product;
import com.dvb.skip_sp.service.ProductService;

@RestController
@RequestMapping("/api/v1/Product")
public class ProductResource implements Serializable {

	private static final long serialVersionUID = 9046976493991381442L;

	@Autowired
	private ProductService productService;

	// @Autowired
	// private Logger Logger;

	@PostMapping()
	public ResponseEntity<Product> save(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		productService.save(product);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/api/v1/Product/{id}").buildAndExpand(product.getId()).toUri());

		// Logger.info(String.format("Product saved [Product: %s]", product));

		return new ResponseEntity<Product>(header, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products = productService.findAll();

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/search/{searchText}")
	public ResponseEntity<List<Product>> getProductText(@PathVariable("searchText") String searchText) {
		List<Product> products = productService.findByNameContaining(searchText);

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long id) {
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
	}

}
