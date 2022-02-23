package api;

import model.*;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T12:04:44+0700"
)
public interface GetModelsQueryResolver extends graphql.kickstart.tools.GraphQLQueryResolver {

    java.util.List<ModelTO> getModels() throws Exception;

}
