package com.example.dell.clapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OnPlay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_play);

        Button comeBackToLibrary = (Button) findViewById(R.id.library_from_on_play);
        comeBackToLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent to open LibraryActivity
                Intent backToLibrary = new Intent(OnPlay.this, Library.class);
                //Start new activity
                startActivity(backToLibrary);
            }
        });

        ImageView goMetadataSong = (ImageView) findViewById(R.id.song_image_on_play);
        goMetadataSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent to open LibraryActivity
                Intent goMetadataSong = new Intent(OnPlay.this, Metadata.class);

                //Store Strings for the song
                //ARTIST
                String theSongArtist = getString(R.string.metadata_song1_artist);
                goMetadataSong.putExtra("SongArtist", theSongArtist);
                //TITLE
                String theSongTitle = getString(R.string.metadata_song1_title);
                goMetadataSong.putExtra("SongTitle", theSongTitle);
                //YEAR
                String theSongYear = getString(R.string.metadata_song1_year);
                goMetadataSong.putExtra("SongYear", theSongYear);

                //Store Images for song1
                goMetadataSong.putExtra("SongImageOne", R.drawable.bowie);

                //Start new activity
                startActivity(goMetadataSong);
            }
        });

        //Display Name&artist of song Activity Library 2 Activity OnPlay
        TextView songName = (TextView) findViewById(R.id.song_title_on_play);
        songName.setText(getIntent().getStringExtra("SongNameOne"));
        /**
         * Longer way to write the same
         **/
        //TextView songName = (TextView)findViewById(R.id.song_title_on_play);
        //Intent i = getIntent();
        //String onPlaySongName = i.getStringExtra("SongNameOne");
        //songName.setText(onPlaySongName);

        //Display Image of song selected Activity Library 2 Activity OnPlay
        ImageView songImage = (ImageView) findViewById(R.id.song_image_on_play);
        int theSongImage = getIntent().getIntExtra("SongImage", R.drawable.bowie);
        songImage.setImageResource(theSongImage);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}



