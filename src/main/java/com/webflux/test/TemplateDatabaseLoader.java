package com.webflux.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TemplateDatabaseLoader {

    @Bean
    CommandLineRunner initialize(ReactiveMongoOperations mongo) {
        return args -> {
            Flux.just(
                            new Item("Alf alarm clock", "kids clock", 19.99),
                            new Item("Smurf TV tray", "kids TV tray", 24.99)
                    )
                    .flatMap(item ->
                            mongo.exists(
                                    Query.query(Criteria.where("name").is(item.getName())),
                                    Item.class
                            ).flatMap(exists -> {
                                if (!exists) {
                                    return mongo.save(item);
                                } else {
                                    return Mono.empty(); // 저장하지 않음
                                }
                            })
                    )
                    .subscribe();
        };
    }
}