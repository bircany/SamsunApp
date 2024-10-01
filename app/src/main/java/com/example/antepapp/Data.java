package com.example.antepapp;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("isim")
    private String isim;

    @SerializedName("fotourl")
    private String fotourl;

    @SerializedName("aciklama")
    private String aciklama;

    public String getIsim() {
        return isim;
    }

    public String getFotourl() {
        return fotourl;
    }

    public String getAciklama() {
        return aciklama;
    }
}