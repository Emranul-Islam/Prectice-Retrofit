package com.emranul.prectice_retrofit;

import java.util.List;

public class DataHolder {
    private List<DataHolderObject> data;

    public DataHolder() {
    }

    public DataHolder(List<DataHolderObject> data) {
        this.data = data;
    }

    public List<DataHolderObject> getData() {
        return data;
    }

    public void setData(List<DataHolderObject> data) {
        this.data = data;
    }
}
