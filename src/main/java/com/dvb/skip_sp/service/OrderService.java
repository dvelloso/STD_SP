package com.dvb.skip_sp.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvb.skip_sp.model.Order;
import com.dvb.skip_sp.model.OrderItem;
import com.dvb.skip_sp.model.Product;
import com.dvb.skip_sp.repository.OrderItemRepository;
import com.dvb.skip_sp.repository.OrderRepository;

@Service
public class OrderService implements Serializable{

	private static final long serialVersionUID = 3622689977816316505L;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public void save(Order order, List<OrderItem> itens) {
		orderRepository.save(order);
		
		for (OrderItem item : itens) {
			item.setOrder(order);
			item.setProduct(new Product(item.getProductId()));
			
			orderItemRepository.save(item);
		}
	}

	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	public void save(Order order) {
		orderRepository.save(order);		
	}

	public List<Order> findAll() {
		return (List<Order>) orderRepository.findAll();
	}
	
	public void setOrderTotal(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		BigDecimal total = BigDecimal.ZERO;
		for (OrderItem item : order.get().getOrderItems()) {
			total.add(item.getTotal());
		}
		order.get().setTotal(total);
		orderRepository.save(order.get());
	}

}