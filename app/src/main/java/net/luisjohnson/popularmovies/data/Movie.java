package net.luisjohnson.popularmovies.data;

import android.net.Uri;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Movie implements Serializable {
    public Movie() {
    }

    private final String POSTER_SIZE = "w200";
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

    public URL getPosterPath()  {

        //String path = URLEncoder.encode(posterPath, "utf-8");

        String builtUri = Uri.parse(POSTER_BASE_URL).buildUpon()
                .appendPath(POSTER_SIZE)
                .appendPath(posterPath)
                .build().toString();

        URL url = null;
        try {
            url = new URL(builtUri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public void setPosterPath(String posterPath) {
        //Remove the first character.
        this.posterPath = posterPath.substring(1);
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
