package com.webflux.test;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    Flux<Item> findByNameContaining(String partialName);
    // end::code[]

    // tag::code-2[]
//	@Query("{ 'name' : ?0, 'age' : ?1 }")
//	Flux<Item> findItemsForCustomerMonthlyReport(String name, int age);
//
//	@Query(sort = "{ 'age' : -1 }")
//	Flux<Item> findSortedStuffForWeeklyReport();
    // end::code-2[]

    // tag::code-3[]
    // search by name
    Flux<Item> findByNameContainingIgnoreCase(String partialName);

    // search by description
    Flux<Item> findByDescriptionContainingIgnoreCase(String partialName);

    // search by name AND description
    Flux<Item> findByNameContainingAndDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);

    // search by name OR description
    Flux<Item> findByNameContainingOrDescriptionContainingAllIgnoreCase(String partialName, String partialDesc);
    // end::code-3[]
}