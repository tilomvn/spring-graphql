package api;

import model.*;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T12:04:44+0700"
)
public interface CreateModelMutationResolver extends graphql.kickstart.tools.GraphQLMutationResolver {

    ModelTO createModel(ModelInputTO modelInput) throws Exception;

}
