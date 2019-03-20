package testandroid.mvp.utils.communication;

import java.io.Serializable;

public class RestView<T> implements Serializable {
    private String status;
    private String title;
    private T body;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
