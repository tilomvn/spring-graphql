package com.spring.graphql;

import com.spring.graphql.services.GraphQLService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(GraphQLService graphQLService) {
		return args -> {
			graphQLService.getModels().forEach(modelTO -> System.out.println(modelTO.getId() + ":" + modelTO.getData()));
		};
	}
}
