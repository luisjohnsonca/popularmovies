package net.luisjohnson.popularmovies.network;

import android.os.AsyncTask;
import android.util.Log;

import net.luisjohnson.popularmovies.data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GetMoviesTask extends AsyncTask <String, Void, Movie[] > {

    private final static String TAG = GetMoviesTask.class.getSimpleName();
    public final static String JSON_ARRAY_KEY = "results";

    final static int MAX_NUMBER_OF_PAGES = 40;

    public AsyncResponse response = null;

    public GetMoviesTask(AsyncResponse response) {
        this.response = response;
    }

    public interface AsyncResponse {
        void returnResponse(Movie[] movies);
    }

    @Override
    protected Movie[] doInBackground(String... paths) {

        List<Movie> list = new ArrayList<>();
        String path = paths[0];

        for(int i = 1; i <= MAX_NUMBER_OF_PAGES; i++ ){
            try {
                URL url = NetworkUtils.buildURL(path, i);
                Log.v(TAG, url.toString());
                String JSONData = NetworkUtils.getHTTPDataFromURL(url);
                JSONObject jsonObject = new JSONObject(JSONData);
                JSONArray jsonArray = jsonObject.getJSONArray(JSON_ARRAY_KEY);
                for(int j = 0; j < jsonArray.length(); j++ ) {
                    Movie movie =  JSONUtils.getMoviesFromJSONData(jsonArray.getJSONObject(j));
                    list.add(movie);
                }
            } catch (IOException | JSONException | ParseException | NullPointerException e) {
                Log.e(TAG, e.getMessage());
            }
        }

        return list.toArray(new Movie[list.size()]);
    }

    @Override
    protected void onPostExecute(Movie[] movies) {
        response.returnResponse(movies);
    }


}
