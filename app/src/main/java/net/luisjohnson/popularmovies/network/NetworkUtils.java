package net.luisjohnson.popularmovies.network;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    final static String BASE_URL = "https://api.themoviedb.org/3/movie";

    final static String API_KEY = "***REMOVED***";


    final static String LANGUAGE = "en-US";


    /**
     * Returns an URL object , build using a base url  and appending a path and two query
     * parameters.
     * @param path
     * @param page
     * @return
     */

    public static URL buildURL(String path, int page) throws MalformedURLException {

        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(path)
                .appendQueryParameter("api_key",API_KEY)
                .appendQueryParameter("language",LANGUAGE)
                .appendQueryParameter("page",String.valueOf(page))
                .build();

        URL url = new URL(builtUri.toString());

        return url;
    }

    public static String getHTTPDataFromURL(URL url) throws IOException{

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
}
