package com.dvb.skip_sp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvb.skip_sp.model.Store;
import com.dvb.skip_sp.repository.StoreRepository;

@Service
public class StoreService implements Serializable {

	private static final long serialVersionUID = -1523109953870458789L;

	@Autowired
	private StoreRepository storeRepository;

	public Optional<Store> findById(Long id) {
		return storeRepository.findById(id);
	}

	public void save(Store store) {
		storeRepository.save(store);
	}

	public List<Store> findAll() {
		return (List<Store>) storeRepository.findAll();
	}

	public List<Store> findByNameContaining(String searchText) {
		return storeRepository.findByNameContaining(searchText);
	}

}
