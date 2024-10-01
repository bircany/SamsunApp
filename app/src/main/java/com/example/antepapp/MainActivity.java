package com.example.antepapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/bircany/SamsunTanitim/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI JsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<DataResponse> call = JsonPlaceHolderAPI.getData();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (!response.isSuccessful()) {
                    Log.e("MainActivity", "Response code: " + response.code());
                    return;
                }

                DataResponse dataResponse = response.body();
                if (dataResponse == null || dataResponse.getAntep() == null || dataResponse.getAntep().isEmpty()) {
                    Log.e("MainActivity", "No data found");
                    return;
                }

                List<Data> dataList = dataResponse.getAntep();
                customAdapter = new CustomAdapter(MainActivity.this, dataList);
                recyclerView.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.e("MainActivity", "Error: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}