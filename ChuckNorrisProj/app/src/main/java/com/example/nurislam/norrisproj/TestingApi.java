package com.example.nurislam.norrisproj;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Nurislam on 22.12.2016.
 */

public class TestingApi {

    private HttpURLConnection urlConnection = null;
    private BufferedReader reader = null;
    private String resultJson = "";
    private String LOG_TAG = "this is log";
    private String result;

    public  TestingApi(){
        try {
            URL url = new URL("http://api.icndb.com/jokes/random");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(100);
            urlConnection.connect();

            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            JSONParser parser = new JSONParser();
            JSONObject json;
            json = (JSONObject) parser.parse(buffer.toString());
//            JSONArray list = (JSONArray) json.get("list");
            JSONObject obj = (JSONObject) json.get("value");
            String main = (String) obj.get("joke");
//            temp = main.get("temp").toString();
//            main = main.toString();
            result = main;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return result;
    }
}
