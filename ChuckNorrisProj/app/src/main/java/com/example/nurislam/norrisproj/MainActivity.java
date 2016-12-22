package com.example.nurislam.norrisproj;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button refreshJoke;
    private String FRAGMENT_KEY = "SFDSDGGFGFGDG";
    JokeFragment jokeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new ApiNorris().execute();
        jokeFragment = new JokeFragment();

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().
                add(R.id.fragmentFirst, jokeFragment, FRAGMENT_KEY).
                commit();

        refreshJoke = (Button) findViewById(R.id.button);
        refreshJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
    }

    public void start(){
        if(jokeFragment != null && jokeFragment.isAdded()){
            if(jokeFragment instanceof JokeFragment) {
                ((JokeFragment) jokeFragment).getRandomJoke();
            }
        }
    }

}
