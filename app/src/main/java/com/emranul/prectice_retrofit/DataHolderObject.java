package com.emranul.prectice_retrofit;

public class DataHolderObject {

    private String resource;
    private String id;
    private String name;
    private String updated_at;

    public DataHolderObject() {
    }

    public DataHolderObject(String resource, String id, String name, String updated_at) {
        this.resource = resource;
        this.id = id;
        this.name = name;
        this.updated_at = updated_at;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
