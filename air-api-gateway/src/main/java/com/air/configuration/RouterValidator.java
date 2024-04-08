package com.air.configuration;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class RouterValidator {
	public static final List<String> openApiEndpoints = List.of(
            "/api/auth"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
