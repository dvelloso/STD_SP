
package com.dvb.skip_sp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.skip_sp.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{

}
