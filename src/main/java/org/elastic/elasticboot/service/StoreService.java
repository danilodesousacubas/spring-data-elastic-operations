package org.elastic.elasticboot.service;

import org.elastic.elasticboot.model.Store;
import org.elastic.elasticboot.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRespository;
	
	@Autowired 
	private ElasticsearchOperations operations;
	
	public Store save(Store store) {
		return storeRespository.save(store);
	}
	
	public Page<Store> findAll(Pageable pageable) {
		return storeRespository.findAll(pageable);
	}
	
	public void delete() {
		operations.deleteIndex(Store.class);
	}
	
	public long count() {
		return storeRespository.count();
	}
}
