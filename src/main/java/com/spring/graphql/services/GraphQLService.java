package com.spring.graphql.services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.graphql.codegen.model.ModelTO;
import com.spring.graphql.config.GraphQLHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphQLService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    final ObjectMapper objectMapper;
    final ResourcePatternResolver resourcePatternResolver;
    final RestTemplate restTemplate;
    final GraphQLHost graphQLHost;

    GraphQLService(ObjectMapper objectMapper, ResourcePatternResolver resourcePatternResolver,
                   RestTemplateBuilder restTemplateBuilder, GraphQLHost graphQLHost) {
        this.objectMapper = objectMapper;
        this.resourcePatternResolver = resourcePatternResolver;
        this.restTemplate = restTemplateBuilder.build();
        this.graphQLHost = graphQLHost;

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public List<ModelTO> getModels() {
        try {
            var variables = objectMapper.createObjectNode();
            variables.put("identifier", "identifier");

            var body = createBody("classpath:graphql-queries/getModels.gql", variables);
            var headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            var response = restTemplate.postForObject(graphQLHost.getHost(), new HttpEntity<>(body, headers), String.class);

            var shapeNode = new ObjectMapper().readTree(response);
            var models = shapeNode.get("data").get("getModels");

            List<ModelTO> modelTOList = new ArrayList<>();
            for (JsonNode jsonNode : models) {
                var model = objectMapper.treeToValue(jsonNode, ModelTO.class);
                modelTOList.add(model);
            }
            return modelTOList;
        } catch (JsonMappingException e) {
            LOGGER.error("JsonMapping error occurred while getting the models: " + e.getMessage());
        } catch (JsonProcessingException e) {
            LOGGER.error("JsonProcessing error occurred while getting the models: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting the shapes: " + e.getMessage());
        }
        return null;
    }


    public String createBody(String path, ObjectNode variables) {
        try {
            var resource = resourcePatternResolver.getResource(path);
            var buffer = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            var query = buffer.lines().collect(Collectors.joining());

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode body = objectMapper.createObjectNode();
            body.put("query", query);
            body.set("variables", variables);

            return body.toString();
        } catch (IOException e) {
            LOGGER.error("Input/Output error occured while creating body: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error occured while creating body: " + e.getMessage());
        }
        return null;
    }
}
