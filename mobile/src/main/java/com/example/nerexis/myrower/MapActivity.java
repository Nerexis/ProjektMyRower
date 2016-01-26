package com.example.nerexis.myrower;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import com.esotericsoftware.kryonet.Client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MapActivity extends AppCompatActivity {

    Button reserveButton;
    Button logoutButton;
    Button settingsButton;
    Button historyButton;

    MultiAutoCompleteTextView fromStationTextBox;
    MultiAutoCompleteTextView toStationTextBox;

    public static MapActivity currentInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentInstance = this;

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

        fromStationTextBox = (MultiAutoCompleteTextView) findViewById(R.id.fromStationSelector);
        toStationTextBox = (MultiAutoCompleteTextView) findViewById(R.id.toStationSelector);
    }
    private void logoutButton_click()
    {
        finish();
    }

    private void reserveButton_click()
    {
        if(fromStationTextBox.getText().length()<=0 || toStationTextBox.length()<=0)
            return;

        Intent reserveIntent = new Intent(this,ReserveActivity.class);
        reserveIntent.putExtra("from", fromStationTextBox.getText().toString());
        reserveIntent.putExtra("to", toStationTextBox.getText().toString());


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        //System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22


        reserveIntent.putExtra("time", timeFormat.format(cal.getTime()));
        reserveIntent.putExtra("date", dateFormat.format(cal.getTime()));
        
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
