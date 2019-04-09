package com.example.rucrowded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button homePage = (Button) findViewById(R.id.homePageBtn);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HomePage.class);
                //Show how to pass information to another activity
                //startIntent.putExtra("orgs.mentorschool.quickLauncher.SOMETHING", "Hello World");
                startActivity(startIntent);
            }
        });

    }
}
