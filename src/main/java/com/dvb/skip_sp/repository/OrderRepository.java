package com.dvb.skip_sp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.skip_sp.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
