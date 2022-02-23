package com.spring.graphql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "graphql.server")
@Data
public class GraphQLHost {
    String host;
}
