package com.spring.graphql.codegen.model;

import java.util.Objects;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T15:06:55+0700"
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ModelTO that = (ModelTO) obj;
        return Objects.equals(id, that.id)
            && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
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
