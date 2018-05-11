package com.example.dell.soccercounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int madridScore = 0;
    int barcelonaScore = 0;
    int yellowMadrid = 0;
    int yellowBarcelona = 0;
    int redMadrid = 0;
    int redBarcelona = 0;
    int cornerMadrid = 0;
    int cornerBarcelona = 0;
    int shootMadrid = 0;
    int shootBarcelona = 0;

    /***Displays score for Madrid.*/
    public void displayForMadrid(int score) {
        TextView scoreView = (TextView) findViewById(R.id.madrid_score);
        scoreView.setText(String.valueOf(score));
    }

    /***Displays score for Barcelona.*/
    public void displayForBarcelona(int score) {
        TextView scoreView = (TextView) findViewById(R.id.barcelona_score);
        scoreView.setText(String.valueOf(score));
    }

    /*** Displays live comments.*/
    public void displayLiveComments(String liveComments) {
        TextView scoreView = (TextView) findViewById(R.id.live_on_field);
        scoreView.setText(String.valueOf(liveComments));
    }

    /***Displays yellow cards for Madrid.*/
    public void displayYellowMadrid(int yellowMadrid) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_for_madrid);
        scoreView.setText(String.valueOf(yellowMadrid));
    }
    /***Displays yellow cards for Barcelona*/
    public void displayYellowBarcelona(int yellowBarcelona) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_for_barcelona);
        scoreView.setText(String.valueOf(yellowBarcelona));
    }

    /***Displays red cards for Madrid.*/
    public void displayRedMadrid(int redMadrid) {
        TextView scoreView = (TextView) findViewById(R.id.red_for_madrid);
        scoreView.setText(String.valueOf(redMadrid));
    }
    /***Displays red cards for Barcelona*/
    public void displayRedBarcelona(int redBarcelona) {
        TextView scoreView = (TextView) findViewById(R.id.red_for_barcelona);
        scoreView.setText(String.valueOf(redBarcelona));
    }

    /***Displays corner for Madrid.*/
    public void displayCornerForMadrid(int cornerMadrid) {
        TextView scoreView = (TextView) findViewById(R.id.corner_for_madrid);
        scoreView.setText(String.valueOf(cornerMadrid));
    }
    /***Displays corner for Barcelona*/
    public void displayCornerForBarcelona(int cornerBarcelona) {
        TextView scoreView = (TextView) findViewById(R.id.corner_for_barcelona);
        scoreView.setText(String.valueOf(cornerBarcelona));
    }

    /***Displays shoot for Madrid.*/
    public void displayShootForMadrid(int shootMadrid) {
        TextView scoreView = (TextView) findViewById(R.id.shoot_for_madrid);
        scoreView.setText(String.valueOf(shootMadrid));
    }
    /***Displays shoot for Barcelona*/
    public void displayShootForBarcelona(int shootBarcelona) {
        TextView scoreView = (TextView) findViewById(R.id.shoot_for_barcelona);
        scoreView.setText(String.valueOf(shootBarcelona));
    }


    /*** Starts game when clicked*/
    public void startGame(View v) {
        displayLiveComments("kick off");
    }

    /*** Break game when clicked*/
    public void breakGame(View v) {
        displayLiveComments("half time");
    }

    /*** Goal for Madrid when clicked.*/
    public void addGoalForMadrid(View v) {
        madridScore = madridScore + 1;
        displayForMadrid(madridScore);
        displayLiveComments("goal madrid");
    }

    /*** Goal for Barcelona when clicked.*/
    public void addGoalForBarcelona(View v) {
        barcelonaScore = barcelonaScore + 1;
        displayForBarcelona(barcelonaScore);
        displayLiveComments("goal barcelona");
    }

    /*** Reset all when clicked.*/
    public void resetAllCounter(View v) {
        madridScore = 0;
        barcelonaScore = 0;
        yellowMadrid = 0;
        yellowBarcelona = 0;
        redMadrid = 0;
        redBarcelona = 0;
        cornerMadrid = 0;
        cornerBarcelona = 0;
        shootMadrid = 0;
        shootBarcelona = 0;

        displayForMadrid(madridScore);
        displayForBarcelona(barcelonaScore);
        displayYellowMadrid(yellowMadrid);
        displayYellowBarcelona(yellowBarcelona);
        displayRedMadrid(redMadrid);
        displayRedBarcelona(redBarcelona);
        displayCornerForMadrid(cornerMadrid);
        displayCornerForBarcelona(cornerBarcelona);
        displayShootForMadrid(shootMadrid);
        displayShootForBarcelona(shootBarcelona);
        displayLiveComments("Live game");
    }

    /*** Finishes game when clicked*/
    public void finalGame(View v) {
        if (madridScore > barcelonaScore == true) {displayLiveComments("madrid wins!");}
        if (madridScore < barcelonaScore == true) {displayLiveComments("barcelona wins!");}
        if (madridScore == barcelonaScore == true) {displayLiveComments("tie game!");}
    }

    /*** Yellow card for Madrid when clicked.*/
    public void getYellowMadrid(View v) {
        yellowMadrid = yellowMadrid + 1;
        displayYellowMadrid(yellowMadrid);
        displayLiveComments("Yellow card for Madrid");
    }
    /*** Yellow card for Barcelona when clicked.*/
    public void getYellowBarcelona(View v) {
        yellowBarcelona = yellowBarcelona + 1;
        displayYellowBarcelona(yellowBarcelona);
        displayLiveComments("Yellow card for Barcelona");
    }

    /*** Red card for Madrid when clicked.*/
    public void getRedMadrid(View v) {
        redMadrid = redMadrid + 1;
        displayRedMadrid(redMadrid);
        displayLiveComments("Red card for Madrid");
    }
    /*** Red card for Barcelona when clicked.*/
    public void getRedBarcelona(View v) {
        redBarcelona = redBarcelona + 1;
        displayRedBarcelona(redBarcelona);
        displayLiveComments("Red card for Barcelona");
    }

    /*** Corner for Madrid when clicked.*/
    public void getCornerMadrid(View v) {
        cornerMadrid = cornerMadrid + 1;
        displayCornerForMadrid(cornerMadrid);
        displayLiveComments("Corner for Madrid");
    }
    /*** Corner for Barcelona when clicked.*/
    public void getCornerBarcelona(View v) {
        cornerBarcelona = cornerBarcelona + 1;
        displayCornerForBarcelona(cornerBarcelona);
        displayLiveComments("Corner for Barcelona");
    }

    /*** Shoot for Madrid when clicked.*/
    public void getShootMadrid(View v) {
        shootMadrid = shootMadrid + 1;
        displayShootForMadrid(shootMadrid);
        displayLiveComments("shoot for Madrid");
    }
    /*** Shoot for Barcelona when clicked.*/
    public void getShootBarcelona(View v) {
        shootBarcelona = shootBarcelona + 1;
        displayShootForBarcelona(shootBarcelona);
        displayLiveComments("Shoot for Barcelona");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
