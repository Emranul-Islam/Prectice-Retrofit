package com.emranul.prectice_retrofit.Country;

import java.util.List;

public class CountryData {
    List<CountryDataObject> data;

    public CountryData() {
    }

    public CountryData(List<CountryDataObject> data) {
        this.data = data;
    }

    public List<CountryDataObject> getData() {
        return data;
    }

    public void setData(List<CountryDataObject> data) {
        this.data = data;
    }
}
