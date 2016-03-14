package com.example.vikas.model;

/**
 * Created by Vikas on 3/11/2016.
 */
public class SearchResultResponse {

    private int version;
    private String status;
    private Response response;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SearchResultResponse{" +
                "version=" + version +
                ", status='" + status + '\'' +
                ", response=" + response +
                '}';
    }
}
