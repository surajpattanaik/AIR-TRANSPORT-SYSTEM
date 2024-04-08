package com.air.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.air.configuration.JwtFeignConfiguration;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthServerRestClient {

	@Autowired
	private RestTemplate restTemplate;

	public Mono<Boolean> validate(String token){
	ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(
            "http://localhost:8081/api/auth/validate/{token}",
            Boolean.class,
            token);
	return  Mono.just(responseEntity.getBody());
	}
}
