package com.dvb.skip_sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.skip_sp.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

	public List<Store> findByNameContaining(String name);
}
