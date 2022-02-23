package com.spring.graphql.codegen.api;

import com.spring.graphql.codegen.model.*;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T14:55:04+0700"
)
public interface GetModelQueryResolver extends graphql.kickstart.tools.GraphQLQueryResolver {

    ModelTO getModel() throws Exception;

}
