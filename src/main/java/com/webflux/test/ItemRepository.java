package com.webflux.test;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;



public interface ItemRepository extends ReactiveCrudRepository<Item, String> {

}