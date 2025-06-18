package com.webflux.test;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyCheck {

    @Value("${spring.webflux.hiddenmethod.filter.enabled:false}")
    private boolean enabled;

    @PostConstruct
    public void logProperty() {
        System.out.println("Hidden method filter enabled: " + enabled);
    }
}