package com.example.android.worldnewstoday;

/**
 * Created by AGUELE OSEKUEMEN JOE on 4/17/2017.
 */

public class News {

    private String mHeadlines;
    private String mUrl;
    private String mDate;
    private String mSource;


    public News(String headlines, String information, String date, String source){

        mHeadlines = headlines;
        mUrl = information;
        mDate = date;
        mSource = source;
    }

    public String getmHeadlines() {
        return mHeadlines;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmSource() {
        return mSource;
    }
}
