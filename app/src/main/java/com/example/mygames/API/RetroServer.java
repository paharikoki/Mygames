package com.example.mygames.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static Retrofit retro;
    private static final String baseUrl="https://20.20.20.6:7139/api/";

    public static Retrofit konekRetrofit(){
        if (retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

}
