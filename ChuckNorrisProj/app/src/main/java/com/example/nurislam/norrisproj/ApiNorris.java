package com.example.nurislam.norrisproj;

import android.os.AsyncTask;


import com.example.nurislam.norrisproj.API.POJO.Value;
import com.example.nurislam.norrisproj.API.Service.ChuckService;

import java.io.IOException;

/**
 * Created by Nurislam on 21.12.2016.
 */

public class ApiNorris extends AsyncTask<Void, Void, Value> {
    private TaskListenner listenner;
    private String result;

    public ApiNorris(TaskListenner listenner) {
        this.listenner = listenner;
    }

    @Override
    protected Value doInBackground(Void... params) {
        Value value = null;
        try {
            value = ChuckService.getValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    protected void onPostExecute(Value value) {
        super.onPostExecute(value);
        result = value.getJoke();
        listenner.onTaskStart(result);
    }

    public String getResult() {
        return result;
    }
}
