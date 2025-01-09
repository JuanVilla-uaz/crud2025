package com.jvc.simplecrud.rest;

import com.jvc.simplecrud.model.rdmProduct.RdmProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class RandomProductClient {
    private final RestClient restClient;

    public RandomProductClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://dummyjson.com/products")
                .build();
    }

    public RdmProduct getRandomProduct(int id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        (req, res) -> {
                            log.error("Failed to get Random Product: " + res.getStatusText());
                            log.error("Failed to get Random Product:" + res.getStatusCode());
                        })
                .onStatus(HttpStatusCode::is5xxServerError,
                        (req, res) ->
                                log.error("Server error: " + res.getStatusText()))
                .onStatus(HttpStatusCode::is2xxSuccessful,
                        (req, res) -> {
                            log.info("Successfully retrieved Random Product: " + res.getStatusCode());
                            log.info("Random Product: " + res.getBody());
                        })
                .body(RdmProduct.class);
    }
}