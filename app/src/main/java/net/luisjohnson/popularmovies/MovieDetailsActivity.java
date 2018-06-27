package net.luisjohnson.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.luisjohnson.popularmovies.data.Movie;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailsActivity.class.getSimpleName();

    @BindView(R.id.image_iv) ImageView posterImageView;
    @BindView(R.id.release_date) TextView releaseDateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        Movie movie = (Movie)intent.getSerializableExtra("movie");

        setTitle(movie.getTitle());

        Log.v(TAG, movie.getTitle());

        URL url = movie.getPosterPath();

        Picasso.get()
                .load(url.toString())
                .into(posterImageView);

    }
}
