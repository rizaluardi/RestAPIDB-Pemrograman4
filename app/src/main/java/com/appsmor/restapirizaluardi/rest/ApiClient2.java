package com.appsmor.restapirizaluardi.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient2 {
    public static final String BASE_URL = "https://inajpnewws.000webhostapp.com/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient2() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}