package com.rudineibrito.apiObserver.services;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiRequest {
    public HttpStatusCode sendRequest() {

        String apiUrl = "https://www.googlehg.com";
        RestTemplate restTemplate =  new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            return response.getStatusCode();
        } catch (HttpClientErrorException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
