package com.webflux.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //<1>
@AutoConfigureWebTestClient // <2>
public class LoadingWebSiteIntegrationTest {

    @Autowired
    WebTestClient client; // <3>

    @Test
        // <4>
    void test() {
        client.get().uri("/").exchange() //
                .expectStatus().isOk() //
                .expectHeader().contentType(TEXT_HTML) //
                .expectBody(String.class)
                .consumeWith(result -> {
                    String body = result.getResponseBody();
                    assertThat(body).contains("<form method=\"post\" action=\"/add/");
                });
    }
}