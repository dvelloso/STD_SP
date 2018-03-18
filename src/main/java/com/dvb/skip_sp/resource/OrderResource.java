package com.dvb.skip_sp.resource;

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

import com.dvb.skip_sp.model.Order;
import com.dvb.skip_sp.service.OrderService;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long id) {
		Optional<Order> order = orderService.findById(id);

		if (!order.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Order	>(order.get(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Order> save(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
		orderService.save(order);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/api/v1/Order/{orderId}").buildAndExpand(order.getId()).toUri());

		return new ResponseEntity<Order>(header, HttpStatus.CREATED);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Order>> getAllOrderByCustomer() {
		List<Order> orders = orderService.findAll();

		if (orders.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

}
