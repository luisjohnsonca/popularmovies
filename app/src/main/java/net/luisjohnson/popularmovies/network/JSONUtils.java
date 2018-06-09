package net.luisjohnson.popularmovies.network;

import net.luisjohnson.popularmovies.data.Movie;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONUtils {

    //JSON Keys declaration
    public static final String TITLE = "title";
    public static final String OVERVIEW = "overview";
    public static final String POPULARITY = "popularity";
    public static final String POSTER_PATH = "poster_path";
    public static final String VOTE_AVERAGE = "vote_average";
    public static final String VOTE_COUNT = "vote_count";
    public static final String RELEASE_DATE = "release_date";

    public static Movie getMoviesFromJSONData( JSONObject jsonObject) throws JSONException, ParseException{




        Movie movie = new Movie();

        movie.setTitle(jsonObject.optString(TITLE));
        movie.setOverview(jsonObject.optString(OVERVIEW));
        movie.setPopularity(jsonObject.optDouble(POPULARITY));
        movie.setPosterPath(jsonObject.optString(POSTER_PATH));
        movie.setVoteAverage(jsonObject.optDouble(VOTE_AVERAGE));
        movie.setVoteCount(jsonObject.optInt(VOTE_COUNT));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(jsonObject.optString(RELEASE_DATE));

        return movie;
    }
}
