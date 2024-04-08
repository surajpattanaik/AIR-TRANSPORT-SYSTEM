package com.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.air.configuration.JwtAuthenticationFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


//	@Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//            .route("JWT-AUTH-SERVER", r -> r.path("/api/auth/**", "/api/test/**")
//                    .uri("lb://JWT-AUTH-SERVER"))
//            .route("AIRPORT-SERVICE", r -> r.path("/api/airports/**")
//                    .uri("lb://AIRPORT-SERVICE"))
//            .route("PLANE-SERVICE", r -> r.path("/api/planes/**")
//                    .uri("lb://PLANE-SERVICE"))
//            .route("SCHEDULE-SERVICE", r -> r.path("/api/schedules/**")
//                    .uri("lb://SCHEDULE-SERVICE"))
//            .route("BOOKING-SERVICE", r -> r.path("/api/bookings/**")
//                    .uri("lb://BOOKING-SERVICE"))
//            .route("PASSENGER-SERVICE", r -> r.path("/api/passengers/**")
//                    .uri("lb://PASSENGER-SERVICE"))
//            .route("ID-GENERATOR-SERVICE", r -> r.path("/api/generate-id/**")
//                    .uri("lb://ID-GENERATOR-SERVICE"))
//            .build();
//    }
	
	    @Bean
	    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	        return builder.routes()
	            .route("JWT-AUTH-SERVER", r -> r.path("/api/auth/**", "/api/test/**")
	            		.filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://JWT-AUTH-SERVER"))
	            .route("AIRPORT-SERVICE", r -> r.path("/api/airports/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://AIRPORT-SERVICE"))
	            .route("PLANE-SERVICE", r -> r.path("/api/planes/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://PLANE-SERVICE"))
	            .route("SCHEDULE-SERVICE", r -> r.path("/api/schedules/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://SCHEDULE-SERVICE"))
	            .route("BOOKING-SERVICE", r -> r.path("/api/bookings/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://BOOKING-SERVICE"))
	            .route("PASSENGER-SERVICE", r -> r.path("/api/passengers/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://PASSENGER-SERVICE"))
	            .route("ID-GENERATOR-SERVICE", r -> r.path("/api/generate-id/**")
	                    .filters(f -> f.filter(jwtAuthenticationFilter))
	                    .uri("lb://ID-GENERATOR-SERVICE"))
	            .build();
	    }

}
