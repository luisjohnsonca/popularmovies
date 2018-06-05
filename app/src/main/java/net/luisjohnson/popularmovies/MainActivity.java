package net.luisjohnson.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.luisjohnson.popularmovies.data.Movie;
import net.luisjohnson.popularmovies.data.MovieAdapter;
import net.luisjohnson.popularmovies.network.GetMoviesTask;

public class MainActivity extends AppCompatActivity implements GetMoviesTask.AsyncResponse {

    private static final String TAG = MainActivity.class.getSimpleName();
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetMoviesTask(this).execute("popular");
    }

    @Override
    public void returnResponse(Movie[] movies) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movie);
        int numberOfColumns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MovieAdapter(this,movies);
        recyclerView.setAdapter(adapter);
    }
}
