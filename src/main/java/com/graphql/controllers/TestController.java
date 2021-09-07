package com.graphql.controllers;

import java.util.Random;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Controller
public class TestController {
	
	@QueryMapping
	public String hello() {
		return "Hello GraphQL";
	}
	
	@QueryMapping
	public Mono<Model> getModel() {
		return Mono.just(new Model("body"));
	}
	
	@QueryMapping
	public Flux<Model> getModels() {
		return Flux.just(new Model("body1"), new Model("body2"));
	}
	
	@QueryMapping
	public Flux<ChildModel> getChildModels() {
		return Flux.just(new ChildModel("child1", new Model("parent")), 
						 new ChildModel("child2", new Model("parent")),
						 new ChildModel("child3", new Model("parent2"))
						 );
	}
	
	@QueryMapping
	public Flux<ChildModel> getChildModelsByModel(@Argument String parent) {
		return Flux.just(new ChildModel("child1", new Model("parent")), 
						 new ChildModel("child2", new Model("parent")),
						 new ChildModel("child3", new Model("parent2"))
						 ).filter(c -> c.model.data.equals(parent));
	}
	
	Random rand = new Random();
	
	class Model {
		long id;
		String data;
		
		Model(String data) { this.id = rand.nextLong(); this.data = data; }
	}
	
	class ChildModel {
		long id;
		String data;
		Model model;
		
		ChildModel(String data, Model parent) {
			this.id = rand.nextLong();
			this.data = data;
			this.model = parent;
		}
	}
}
