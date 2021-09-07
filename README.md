# GrapQL
* The main difference between REST and GraphQL is GraphQL has only one endpoint for all apis whereas REST have one endpoint for one api in the same context.
* How it works: it does post Query, Mutations json object to default endpoint /graphql, server do serialization and map to controller
for retrieving data.
```
{
  getModels {
    id
    data
  }
  getChildModels {
    id
    data
    model {
      id
      data
    }
  }
  getChildModelsByModel(parent: "parent") {
    id
    data
    model {
      id
      data
    }
  }
}

```
* GraphQL UI for testing : http://localhost:5050/graphiql ![](/src/main/resources/GraphIQL.png "")
* Reference: https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/