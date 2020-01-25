package org.elastic.elasticboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "store", type = "purchase", shards = 1, replicas = 0, refreshInterval = "-1")
public class Store {
	@Id
	private String id;
	private String name;
}