package com.example.sergio.guardianappnews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

//Loads a list of Articles by using an AsyncTask to perform the network request to the given URL.

public class ArticleLoader extends AsyncTaskLoader<List<Article>>{

    //Tag for log messages
    private static final String LOG_TAG = ArticleLoader.class.getName();

    // Query for URL
    private String mWebUrl;

    //Load list of articles based on the url related to the query
    public ArticleLoader(Context context, String webUrl) {
        super(context);
        mWebUrl = webUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (mWebUrl == null) {
            return null;
        }

        List<Article> articles = QueryUtils.fetchArticleData(mWebUrl);
        return articles;
    }
}
