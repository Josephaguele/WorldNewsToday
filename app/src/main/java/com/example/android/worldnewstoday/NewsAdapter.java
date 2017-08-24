package com.example.android.worldnewstoday;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.worldnewstoday.R.id.date;

/**
 * Created by AGUELE OSEKUEMEN JOE on 4/18/2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {


    /*use for the separation of date gotten from the url site*/
    private static final String DATE_SEPARATOR = "T";
    private static final String DATE_ARRANGER = "-";


    public NewsAdapter(Activity context, List<News> newsStories) {
        super(context,0, newsStories);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View listView = convertView;
        if (listView  == null){
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);
        }

        News currentNews = getItem(position);


          /*Here a small break down is done. The original date that comes from the website is in the format
        * 2017-04-14T18:00:00Z
        * So we split it into the date part only for the app to use as date*/
        //Split the string --2017-04-14T18:00:00Z-- into different parts (as an array of Strings)
        // based on the "T" text. We take only the strings before the letter "T" that appears in the date.
        // The real date string will now be only 2017-04-14
        String datey =currentNews.getmDate();
        final String[]parts= datey.split(DATE_SEPARATOR);
        String realDate = parts[0];

       /*Here we convert the broken string of date which is now in the form of 2017-04-14 to a more readable form i.e in
         in this order: date,month and year.
         The first part of the date is split by the "-"
         followed by the second part
         and the third part and finally we rearrange them in that order that we want.*/
        String[]yearPart = realDate.split(DATE_ARRANGER);
        String year = yearPart[0];
        String month = yearPart[1];
        String dates = yearPart[2];
        String rearrangeDate = dates +"-"+ month+"-"+ year;



        TextView newsDate = (TextView) listView.findViewById(date);
        newsDate.setText(rearrangeDate);

        TextView source = (TextView) listView.findViewById(R.id.source);
        source.setText(currentNews.getmSource());

        TextView headlines = (TextView)listView.findViewById(R.id.headlines);
        headlines.setText(currentNews.getmHeadlines());
        return listView;
    }


    public void setNews(ArrayList<News> newses) {
    }
}
