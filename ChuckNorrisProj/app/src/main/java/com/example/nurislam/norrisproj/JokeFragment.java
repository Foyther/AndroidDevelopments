package com.example.nurislam.norrisproj;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nurislam on 22.12.2016.
 */

public class JokeFragment extends Fragment {
    TextView tv;
    ApiNorris apiNorris;
    TestingApi testingApi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.joke, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tv = (TextView) view.findViewById(R.id.textJoke);
        changeText("This is working");
    }

    public void getRandomJoke() {
        apiNorris = new ApiNorris();
        apiNorris.execute();
        changeText(apiNorris.getResult());

//        testingApi = new TestingApi();
//        changeText(testingApi.getResult());
    }

    public void changeText(String txt) {
        if (tv != null) {
            if (txt == null) {
                tv.setText("ERROR");
            } else
                tv.setText(txt);
        }
    }

}
