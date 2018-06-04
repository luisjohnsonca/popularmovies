package net.luisjohnson.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.luisjohnson.popularmovies.network.GetMoviesTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetMoviesTask().execute("popular");
    }
}
