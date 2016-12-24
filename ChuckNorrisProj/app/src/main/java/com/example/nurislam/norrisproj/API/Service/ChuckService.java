package com.example.nurislam.norrisproj.API.Service;

import com.example.nurislam.norrisproj.API.POJO.Value;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nurislam on 23.12.2016.
 */

public class ChuckService {


    public static APIModel getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIModel.class);
    }

    public static Value getValue() throws IOException {
        Response<Value> response = ChuckService.getAPI().getJoke().execute();
        return response.body();
    }
}
