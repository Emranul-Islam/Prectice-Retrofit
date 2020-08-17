package com.emranul.prectice_retrofit;

import com.emranul.prectice_retrofit.Country.CountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Clint {
    @GET("continents")
    Call<DataHolder> getData(@Query("api_token") String api_token);

    @GET("countries")
    Call<CountryData> getCountyData(@Query("api_token") String api_token, @Query("sort") String continent_id);
}
