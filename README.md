# Spring Data - Elastic Search Query Operations

## To Run Elastic Search single node:
```command
$ docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.8.2 
```

## To Run project:
```command
$ mvn clean install spring-boot:run 
```

```command
#### Obs: Ubuntu docker.sock 
$ sudo chmod 666 /var/run/docker.sock
$ sudo chown root:docker /var/run/docker.sock
```
