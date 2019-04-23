package com.example.rucrowded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Locations extends AppCompatActivity {

    private static final String url = "capstone2019.cpayr1ebu9xg.us-east-2.rds.amazonaws.com";
    private static final String user = "administrator";
    private static final string pass = "capstone2019";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
    }
}
