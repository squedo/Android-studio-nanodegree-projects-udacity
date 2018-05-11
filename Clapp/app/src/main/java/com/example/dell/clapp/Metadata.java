package com.example.dell.clapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Metadata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metadata);

        Button comeBackToOnPlay = (Button) findViewById(R.id.on_play_from_metadata);
        comeBackToOnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Use OnBackPressed method to come back with info to activity_on_play
                onBackPressed();
            }
        });

        //Display Artist of song selected
        TextView songArtist = (TextView) findViewById(R.id.artist_metadata);
        songArtist.setText(getIntent().getStringExtra("SongArtist"));

        //Display Title of song selected
        TextView songTitle = (TextView) findViewById(R.id.title_metadata);
        songTitle.setText(getIntent().getStringExtra("SongTitle"));

        //Display Year of song selected
        TextView songYear = (TextView) findViewById(R.id.year_metadata);
        songYear.setText(getIntent().getStringExtra("SongYear"));

        //Display Image of song selected
        ImageView songImage = (ImageView) findViewById(R.id.song_image_on_metadata);
        int theSongImage = getIntent().getIntExtra("SongImageOne", R.drawable.clapp_icon);
        songImage.setImageResource(theSongImage);

    }
}
