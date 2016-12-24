package com.example.nurislam.norrisproj;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nurislam on 22.12.2016.
 */

public class JokeFragment extends Fragment implements TaskListenner {
    private TextView tv;
    private ApiNorris apiNorris;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.joke, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tv = (TextView) view.findViewById(R.id.textJoke);
        if (savedInstanceState != null) {
            tv.setText(savedInstanceState.getString("joke"));
        } else
        changeText("This is working");
    }

    public void getRandomJoke() {
        apiNorris = new ApiNorris(this);
        apiNorris.execute();
    }

    public void changeText(String txt) {
        if (tv != null) {
            if (txt == null) {
                tv.setText("ERROR");
            } else
                tv.setText(txt);
        }
    }

    public TextView getTv(){
        return this.tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("joke", (String) tv.getText());
    }

    @Override
    public void onTaskFinish() {

    }

    @Override
    public boolean onTaskStart(String start) {
        changeText(start);
        return true;
    }
}
