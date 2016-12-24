package com.example.nurislam.norrisproj.API.Service;

import com.example.nurislam.norrisproj.API.POJO.Value;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nurislam on 23.12.2016.
 */

public interface APIModel {
    @GET("/jokes/random")
    Call<Value> getJoke();
}
