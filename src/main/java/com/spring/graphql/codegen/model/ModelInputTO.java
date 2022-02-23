package com.spring.graphql.codegen.model;

import java.util.Objects;

@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T15:06:55+0700"
)
public class ModelInputTO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String data;

    public ModelInputTO() {
    }

    public ModelInputTO(String data) {
        this.data = data;
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
        final ModelInputTO that = (ModelInputTO) obj;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }


    public static ModelInputTO.Builder builder() {
        return new ModelInputTO.Builder();
    }

    public static class Builder {

        private String data;

        public Builder() {
        }

        public Builder setData(String data) {
            this.data = data;
            return this;
        }


        public ModelInputTO build() {
            return new ModelInputTO(data);
        }

    }
}
