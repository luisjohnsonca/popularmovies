package net.luisjohnson.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import net.luisjohnson.popularmovies.data.Movie;
import net.luisjohnson.popularmovies.data.MovieAdapter;
import net.luisjohnson.popularmovies.network.GetMoviesTask;

public class MainActivity extends AppCompatActivity implements GetMoviesTask.AsyncResponse {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String POPULAR_PATH = "popular";
    private static final String TOP_RATED_PATH = "top_rated";

    MovieAdapter adapter;
    GetMoviesTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetMoviesTask(this).execute(POPULAR_PATH);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int SelectedItem = item.getItemId();
        String path;
        switch (SelectedItem) {
            case R.id.popular:
                path = POPULAR_PATH;
                break;
            case R.id.top_rated:
                path = TOP_RATED_PATH;
                break;
            default:
                path = POPULAR_PATH;
                break;
        }

        new GetMoviesTask(this).execute(path);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_options, menu);
        return true;
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
