package com.agosh.keycloak2fa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Slf4j
public class RestTemplateFactory {

    public static RestTemplate build(String baseUrl) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
        log.info("Building rest template with base URL: {}", baseUrl);
        return restTemplate;
    }

}
