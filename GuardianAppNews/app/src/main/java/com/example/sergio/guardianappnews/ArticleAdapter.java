package com.example.sergio.guardianappnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }

        Article currentArticle = getItem(position);

        //TV_ID_title
        TextView titleView = listItemView.findViewById(R.id.name);
        titleView.setText(currentArticle.getWebTitle());

        //TV_ID_publish
        TextView publishedView = listItemView.findViewById(R.id.info_textview);
        publishedView.setText(currentArticle.getWebPublicationDate());

        //Return list
        return listItemView;
    }
}