package model;


@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T12:04:44+0700"
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
