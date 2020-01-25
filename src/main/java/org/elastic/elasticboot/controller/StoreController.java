package org.elastic.elasticboot.controller;

import org.elastic.elasticboot.exceptions.StoreNotFoundException;
import org.elastic.elasticboot.model.Store;
import org.elastic.elasticboot.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/store")
public class StoreController {
	final static Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@PostMapping
	public Store create(@RequestBody final Store store) {
		Store storePersisted = storeService.save(store);
		LOGGER.info(String.format("created store id: {id}", storePersisted.getId()));
		return store;
	}

	@GetMapping("/{id}")
	public Store findOne(@PathVariable final String id) throws StoreNotFoundException {
		LOGGER.info(String.format("find store by id: {%s}", id));
		return storeService.findOnde(id).orElseThrow(() -> new StoreNotFoundException());
	}

	@GetMapping
	public Page<Store> findAll(Pageable pageable) {
		LOGGER.info("find all stores");
		Page<Store> stores = storeService.findAll(pageable);
		LOGGER.info(String.format("store size [%d]", stores.getSize()));
		
		return stores;
	}

	@GetMapping("/count")
	public long count(Pageable pageable) {
		LOGGER.info("get count stores");
		return storeService.count();
	}

	@GetMapping("/query")
	public Page<Store> findByStoreName(Pageable pageable, @RequestParam("store-name") final String storeName) {
		LOGGER.info(String.format("find store by name: [%s]", storeName));
		return storeService.findByStoreNameUsingCustomQuery(storeName, pageable);
	}

	@DeleteMapping("/operation/delete")
	public void delete() {
		LOGGER.info("elastic operation for delete index");
		storeService.delete();
	}
}