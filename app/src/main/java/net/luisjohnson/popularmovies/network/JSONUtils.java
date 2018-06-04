package net.luisjohnson.popularmovies.network;

import net.luisjohnson.popularmovies.data.Movie;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONUtils {

    public static Movie getMoviesFromJSONData( JSONObject jsonObject) throws JSONException, ParseException{

        Movie movie = new Movie();

        movie.setTitle(jsonObject.getString("title"));
        movie.setOverview(jsonObject.getString("overview"));
        movie.setPopularity(jsonObject.getDouble("popularity"));
        movie.setPosterPath(jsonObject.getString("poster_path"));
        movie.setVoteAverage(jsonObject.getDouble("vote_average"));
        movie.setVoteCount(jsonObject.getInt("vote_count"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(jsonObject.getString("release_date"));

        return movie;
    }
}
