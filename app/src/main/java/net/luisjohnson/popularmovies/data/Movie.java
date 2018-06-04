package net.luisjohnson.popularmovies.data;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Movie {
    public Movie() {
    }

    private final String POSTER_SIZE = "w500";
    private final String POSTER_BASE_URL = "https://image.tmdb.org/t/p";

    private int voteCount;
    private double voteAverage;
    private String title;
    private double popularity;
    private String posterPath;
    private String overview;
    private Date releaseDate;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public URL getPosterPath() throws MalformedURLException {
        Uri builtUri = Uri.parse(POSTER_BASE_URL).buildUpon()
                .appendPath(POSTER_SIZE)
                .appendPath(posterPath)
                .build();
        URL url = new URL(builtUri.toString());

        return url;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
