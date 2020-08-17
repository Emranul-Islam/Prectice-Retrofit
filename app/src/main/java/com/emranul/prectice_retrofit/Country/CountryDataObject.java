package com.emranul.prectice_retrofit.Country;

public class CountryDataObject {
    private String resource;
    private String id;
    private String continent_id;
    private String name;

    public CountryDataObject() {
    }

    public CountryDataObject(String resource, String id, String continent_id, String name) {
        this.resource = resource;
        this.id = id;
        this.continent_id = continent_id;
        this.name = name;
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

    public String getContinent_id() {
        return continent_id;
    }

    public void setContinent_id(String continent_id) {
        this.continent_id = continent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
