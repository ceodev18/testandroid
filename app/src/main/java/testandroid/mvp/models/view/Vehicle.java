package testandroid.mvp.models.view;

import java.io.Serializable;
import java.util.List;

public class Vehicle implements Serializable {
    private String type;
    private Long id;
    private Content attributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Content getAttributes() {
        return attributes;
    }

    public void setAttributes(Content attributes) {
        this.attributes = attributes;
    }

    public static class Content{
        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
