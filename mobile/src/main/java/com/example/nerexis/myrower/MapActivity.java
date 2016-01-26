package com.example.nerexis.myrower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.esotericsoftware.kryonet.Client;

public class MapActivity extends AppCompatActivity {

    Button reserveButton;
    Button logoutButton;
    Button settingsButton;
    Button historyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reserveButton = (Button) findViewById(R.id.reserveButton);

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reserveButton_click();

            }
        });

        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutButton_click();
            }
        });

        settingsButton = (Button) findViewById(R.id.settingsButton);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsButton_click();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsButton_click();
            }
        });

        historyButton = (Button) findViewById(R.id.historyButton);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyButton_click();
            }
        });
    }
    private void logoutButton_click()
    {
        finish();
    }

    private void reserveButton_click()
    {
        Intent reserveIntent = new Intent(this,ReserveActivity.class);
        startActivity(reserveIntent);
    }
    private void settingsButton_click()
    {
        Intent settingsIntent = new Intent(this,SettingsActivity.class);
        startActivity(settingsIntent);
    }
    private void historyButton_click()
    {
        Intent historyIntent = new Intent(this,HistoryActivity.class);
        startActivity(historyIntent);
    }
    public void onBackPressed()
    {
        finish();
    }

}
