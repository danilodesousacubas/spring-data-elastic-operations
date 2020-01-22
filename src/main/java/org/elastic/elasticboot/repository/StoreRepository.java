package org.elastic.elasticboot.repository;

import org.elastic.elasticboot.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StoreRepository extends ElasticsearchRepository<Store, String> {
	Page<Store> findByName(String name, Pageable pageable);

	@Query("{\"bool\": {\"must\": [{\"match\": {\"store.name\": \"?0\"}}]}}")
	Page<Store> findByStoreNameUsingCustomQuery(String name, Pageable pageable);
}
