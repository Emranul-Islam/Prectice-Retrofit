package com.emranul.prectice_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final String base_url = "https://cricket.sportmonks.com/api/v2.0/";
    private final String api_token = "sCrG1y0JVLl04XC2QxP3yieyOTgIAdWo27RHFftu5DIYD4PQy3ReoUkHA9fq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Clint clint = retrofit.create(Clint.class);

        Call<DataHolder> data = clint.getData(api_token);

        data.enqueue(new Callback<DataHolder>() {
            @Override
            public void onResponse(Call<DataHolder> call, Response<DataHolder> response) {
                if (response.isSuccessful()) {

                    List<DataHolderObject> list = response.body().getData();
                    Toast.makeText(MainActivity.this, "Loading....", Toast.LENGTH_SHORT).show();
                    Adapter adapter = new Adapter(MainActivity.this, list);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataHolder> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
