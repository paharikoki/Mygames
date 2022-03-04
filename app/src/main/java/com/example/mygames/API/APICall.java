package com.example.mygames.API;

import com.example.mygames.Model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {
    @GET("GameDetails")
    Call<DataModel> getGameDetails();
}
