package com.emranul.prectice_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyRetrofit {
    @GET("237d4da48a02f152fd17")
    Call<List<DataHolder>> getData();
}
