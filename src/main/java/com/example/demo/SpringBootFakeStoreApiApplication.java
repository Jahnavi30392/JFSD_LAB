package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.ProductService;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFakeStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFakeStoreApiApplication.class, args);
	}
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	@Bean
	public CommandLineRunner testApi(ProductService productService) {
	    return args -> {
	        System.out.println("Fetching products from Fake Store API...");
	        productService.getAllProducts().forEach(product -> {
	            System.out.println("Product: " + product.getTitle());
	        });
	    };
	}


}
