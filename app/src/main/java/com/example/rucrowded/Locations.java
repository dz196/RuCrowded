package com.example.rucrowded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Locations extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        listView = (ListView) findViewById(R.id.listview_locations);

        final ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Jon and Steve's apartment");
        arrayList.add("David's house");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String row = arrayList.get(position).toString();
                Toast.makeText(Locations.this, "clicked item:" + position + " " + row, Toast.LENGTH_SHORT).show();

                switch(position){
                    case 0:
                        Intent startIntent = new Intent(getApplicationContext(), JonSteveApartment.class);
                        startActivity(startIntent);
                }
            }
        });
    }
}
