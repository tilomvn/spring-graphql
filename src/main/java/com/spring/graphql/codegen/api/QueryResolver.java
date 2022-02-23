package api;

import model.*;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T12:04:44+0700"
)
public interface QueryResolver extends graphql.kickstart.tools.GraphQLQueryResolver {

    String hello() throws Exception;

    ModelTO getModel() throws Exception;

    java.util.List<ModelTO> getModels() throws Exception;

    java.util.List<ChildModelTO> getChildModels() throws Exception;

    java.util.List<ChildModelTO> getChildModelsByModel(String parent) throws Exception;

}
