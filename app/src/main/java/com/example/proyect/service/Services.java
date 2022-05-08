package com.example.proyect.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {
    public Retrofit retrofit;

    private static final String BASE_URL = "https://blynk.cloud/external/";

    public Services(String uri) {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL + uri).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
