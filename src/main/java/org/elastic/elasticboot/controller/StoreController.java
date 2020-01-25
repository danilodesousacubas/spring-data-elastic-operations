package org.elastic.elasticboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import org.elastic.elasticboot.exceptions.StoreNotFoundException;
import org.elastic.elasticboot.model.Store;
import org.elastic.elasticboot.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/store")
public class StoreController {
	final static Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;

	@PostMapping
	public  ResponseEntity<Store> create(@RequestBody final Store store) throws URISyntaxException {
		LOGGER.info("Request to create store: {}", store);
		Store persisted = storeService.save(store);
		
		return ResponseEntity.created(new URI("api/store" + persisted.getId())).body(persisted);
	}
	
	@PutMapping("/{id}")
    ResponseEntity<Store> updateGroup(@Valid @RequestBody Store store) {
        LOGGER.info("Request to update group: {}", store);
        Store persisted = storeService.save(store);
        return ResponseEntity.ok().body(persisted);
    }

	@GetMapping("/{id}")
	public Store findOne(@PathVariable final String id) throws StoreNotFoundException {
		LOGGER.info(String.format("find store by id: {%s}", id));
		return storeService.findOnde(id).orElseThrow(StoreNotFoundException::new);
	}

	@GetMapping
	public Page<Store> findAll(Pageable pageable) {
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