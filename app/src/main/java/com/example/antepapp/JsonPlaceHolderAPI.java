package com.example.antepapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    @GET("samsun.json")
    Call<DataResponse> getData();
}