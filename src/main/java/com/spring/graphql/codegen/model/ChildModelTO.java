package model;


@javax.annotation.processing.Generated(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "2022-02-23T12:04:44+0700"
)
public class ChildModelTO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String data;
    private ModelTO model;

    public ChildModelTO() {
    }

    public ChildModelTO(String id, String data, ModelTO model) {
        this.id = id;
        this.data = data;
        this.model = model;
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

    public ModelTO getModel() {
        return model;
    }
    public void setModel(ModelTO model) {
        this.model = model;
    }



    public static ChildModelTO.Builder builder() {
        return new ChildModelTO.Builder();
    }

    public static class Builder {

        private String id;
        private String data;
        private ModelTO model;

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

        public Builder setModel(ModelTO model) {
            this.model = model;
            return this;
        }


        public ChildModelTO build() {
            return new ChildModelTO(id, data, model);
        }

    }
}
