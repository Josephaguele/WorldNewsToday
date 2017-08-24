package com.example.android.worldnewstoday;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by AGUELE OSEKUEMEN JOE on 4/20/2017.
 */


public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /*Tag for log messages*/
    private static final String LOG_TAG = NewsLoader.class.getName();
    /*Query URL*/
    private String mUrl;

    /*Constructs a new {@link FootballLoader}
   *@param context of the activity
   *@param url to load data from*/
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();

    }
    @Override
    public List<News> loadInBackground() {
        Log.i(LOG_TAG, "LOAD IN BACKGROUND RUNNING");
        if (mUrl == null) {
            return null;
        }
            // Perform the network request, parse the response, and extract a list of football games
            List<News> news = QueryUtils.fetchNewsData(mUrl);
            return news;
            // load in background works like the AsyncTask doInBackground method.


    }

    }
