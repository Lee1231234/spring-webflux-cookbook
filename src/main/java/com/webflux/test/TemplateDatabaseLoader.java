package com.webflux.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {

    @Bean
    CommandLineRunner initialize(ReactiveMongoOperations mongo) {
        return args -> {
            mongo.save(new Item("Alf alarm clock", 19.99))
                    .then(mongo.save(new Item("Smurf TV tray", 24.99)))
                    .subscribe();
        };
    }
}