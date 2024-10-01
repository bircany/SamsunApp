package com.example.antepapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("samsun")
    private List<Data> samsun;

    public List<Data> getSamsun() {
        return samsun;
    }
}