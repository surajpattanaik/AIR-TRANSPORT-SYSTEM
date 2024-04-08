package com.air.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "id-generator-service")
public interface IdGeneratorFeignClient {
	
	@GetMapping("/api/generate-id")
	public String getGeneratedId();
}
