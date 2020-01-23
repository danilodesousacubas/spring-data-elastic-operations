package org.elastic.elasticboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticBootApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticBootApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("starting elastic boot application");
		SpringApplication.run(ElasticBootApplication.class, args);
	}
	
}