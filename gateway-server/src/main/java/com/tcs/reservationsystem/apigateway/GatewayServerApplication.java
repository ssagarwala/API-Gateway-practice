package com.tcs.reservationsystem.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("customer-route", r -> r.path("/customers/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://customer-service"))
				.route("reservation-route", r -> r.path("/reservations/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://reservation-service"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

}

//localhost:8080/customer-service/customers/1