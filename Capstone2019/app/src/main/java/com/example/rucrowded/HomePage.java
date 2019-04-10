package com.example.rucrowded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        /* Get extra info from previous page
        if (getIntent().hasExtra("orgs.mentorschool.quickLauncher.SOMETHING")){
            TextView tv = (TextView)findViewById(GetTextBoxHere);
            String text = getIntent().hasExtra.get("orgs.mentorschool.quickLauncher.SOMETHING");
        }*/

        Button favorites = (Button) findViewById(R.id.favoritesBtn);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Favorites.class);
                startActivity(startIntent);
            }
        });
        Button locations = (Button) findViewById(R.id.locationsBtn);
        locations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Locations.class);
                startActivity(startIntent);
            }
        });
    }
}
