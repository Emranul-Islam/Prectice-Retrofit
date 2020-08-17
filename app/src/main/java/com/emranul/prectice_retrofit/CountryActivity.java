package com.emranul.prectice_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.Toast;

import com.emranul.prectice_retrofit.Country.CountryAdapter;
import com.emranul.prectice_retrofit.Country.CountryData;
import com.emranul.prectice_retrofit.Country.CountryDataObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class CountryActivity extends AppCompatActivity {
    private final String base_url = "https://cricket.sportmonks.com/api/v2.0/";
    private final String api_token = "sCrG1y0JVLl04XC2QxP3yieyOTgIAdWo27RHFftu5DIYD4PQy3ReoUkHA9fq";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countery);

        final String continents_id = getIntent().getStringExtra("continents_id");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = findViewById(R.id.country_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Clint clint = retrofit.create(Clint.class);
        Call<CountryData> data = clint.getCountyData(api_token, "name");

        data.enqueue(new Callback<CountryData>() {
            @Override
            public void onResponse(Call<CountryData> call, Response<CountryData> response) {
                if (response.isSuccessful()) {
                    List<CountryDataObject> list = response.body().getData();

                    List<CountryDataObject> myList = null;
                    for (CountryDataObject object : list) {

                        if (object.getContinent_id().equals(continents_id)) {

                        }

                    }
                    //CountryAdapter adapter = new CountryAdapter(CountryActivity.this, list);

                    CountryAdapter adapter = new CountryAdapter(CountryActivity.this, list);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(CountryActivity.this, "Error" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CountryData> call, Throwable t) {

                Toast.makeText(CountryActivity.this, "Error2" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}