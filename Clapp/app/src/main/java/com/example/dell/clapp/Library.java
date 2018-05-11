package com.example.dell.clapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Library extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ImageButton goOnPlaySong = (ImageButton) findViewById(R.id.song_1_play);
        goOnPlaySong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent to open OnPlay
                Intent goOnPlaySongIntent = new Intent(Library.this, OnPlay.class);

                //Store Strings for song1
                TextView songName1 = (TextView) findViewById(R.id.song_1_title);
                String songNameOne = songName1.getText().toString();
                goOnPlaySongIntent.putExtra("SongNameOne", songNameOne);

                //Store Images for song1
                goOnPlaySongIntent.putExtra("SongImageOne",R.drawable.bowie);

                //Start new activity OnPlay with info of song that has been clicked
                startActivity(goOnPlaySongIntent);
            }
        });
    }
}