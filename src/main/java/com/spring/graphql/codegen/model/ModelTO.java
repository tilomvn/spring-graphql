package com.spring.graphql.codegen.model;


@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T14:55:04+0700"
)
public class ModelTO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String data;

    public ModelTO() {
    }

    public ModelTO(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }



    public static ModelTO.Builder builder() {
        return new ModelTO.Builder();
    }

    public static class Builder {

        private String id;
        private String data;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setData(String data) {
            this.data = data;
            return this;
        }


        public ModelTO build() {
            return new ModelTO(id, data);
        }

    }
}
