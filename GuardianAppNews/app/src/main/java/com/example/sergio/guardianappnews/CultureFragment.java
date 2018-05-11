package com.example.sergio.guardianappnews;


import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CultureFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Article>> {

    // The callbacks through which we will interact with the LoaderManager.

    //Definitions
    private ListView articleListView;
    private ArticleAdapter adapter;
    private SearchView searchView;
    private String mQuery;
    private TextView mEmptyStateTextView;
    private ProgressBar mProgressBar;
    //Tag for log messages
    public static final String LOG_TAG = CultureFragment.class.getName();
    //URL to query the article data set for article information, I got this first URL from
    private static final String ARTICLE_REQUEST_URL =
            "https://content.guardianapis.com/search?section=culture";

    //Constant value for the article loader ID
    private static final int ARTICLE_LOADER_ID = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.article_list, container, false);

        searchView = rootView.findViewById(R.id.search_view);
        articleListView = rootView.findViewById(R.id.list);
        adapter = new ArticleAdapter(getActivity(), new ArrayList<Article>());
        articleListView.setAdapter(adapter);

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Article currentArticle = adapter.getItem(position);
                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri ArticleUri = Uri.parse(currentArticle.getWebUrl());
                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, ArticleUri);
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        // Find the reference to the progress bar in a layout
        mProgressBar = rootView.findViewById(R.id.progress_bar);
        // Find the reference to the empty text view in a layout and set empty view
        mEmptyStateTextView = rootView.findViewById(R.id.empty_view);
        articleListView.setEmptyView(mEmptyStateTextView);

        if (isConnected()) {
            LoaderManager loaderManager = getActivity().getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);

        } else {
            mProgressBar.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                if (isConnected()) {
                    articleListView.setVisibility(View.INVISIBLE);
                    mEmptyStateTextView.setVisibility(View.GONE);
                    mProgressBar.setVisibility(View.VISIBLE);
                    mQuery = searchView.getQuery().toString();
                    mQuery = mQuery.replace(" ", "+");
                    Log.v(LOG_TAG, mQuery);
                    getActivity().getLoaderManager().restartLoader(ARTICLE_LOADER_ID, null, CultureFragment.this);
                    searchView.clearFocus();
                } else {
                    articleListView.setVisibility(View.INVISIBLE);
                    mProgressBar.setVisibility(View.GONE);
                    mEmptyStateTextView.setVisibility(View.VISIBLE);
                    mEmptyStateTextView.setText(R.string.no_internet);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return rootView;
    }

    // Helper method to check network connection
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {
        String requestUrl;
        if (mQuery != null && mQuery.equals("")) {
            requestUrl = ARTICLE_REQUEST_URL + mQuery;
            //Log.d(LOG_TAG,requestUrl);
        } else {
            String defaultQuery = /**"culture" + */"&api-key=test";
            requestUrl = ARTICLE_REQUEST_URL + defaultQuery;
            //Log.d(LOG_TAG,requestUrl);
        }
        return new ArticleLoader(getContext(), requestUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articles) {

        mEmptyStateTextView.setText(R.string.no_search);
        mProgressBar.setVisibility(View.GONE);
        adapter.clear();

        if (articles != null && !articles.isEmpty()) {
            adapter.addAll(articles);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        adapter.clear();
    }
}
