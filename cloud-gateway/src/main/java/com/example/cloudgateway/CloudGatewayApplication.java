package com.example.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}

/**
 * Start all applications with profile dev
 * Before:
 * You can access with http://localhost:8082/test/check
 * or with consumer with:
 *
 * http://localhost:8081/test/checkconnectiontoprovider
 *
 * What is new here? We can now use this to Route requests!
 * So we can use this + Eureka to route requests and dont have
 * to call the eureka to get hostname and port anymore!
 *
 * We just have a Eureka Client here
 * We use it to connect to other Services connected to Eureka.
 *
 * We need to use the eureka-loadbalancer (see config) where
 * we specify with lb://needed-eureka-client-name-that-is-shown-in-the-registry
 *
 * Then we can access like that (if we use dev config for all 4 apps):
 *
 * http://localhost:8080/test/checkconnectiontoprovider
 */