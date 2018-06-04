package net.luisjohnson.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.luisjohnson.popularmovies.data.Movie;
import net.luisjohnson.popularmovies.network.GetMoviesTask;

public class MainActivity extends AppCompatActivity implements GetMoviesTask.AsyncResponse {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetMoviesTask(this).execute("popular");
    }

    @Override
    public void returnResponse(Movie[] movies) {
        for(Movie movie:movies) { Log.v(TAG, movie.getTitle()); }
    }
}
