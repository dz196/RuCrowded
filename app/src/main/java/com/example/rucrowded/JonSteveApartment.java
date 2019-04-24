package com.example.rucrowded;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JonSteveApartment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jon_steve_apartment);
        new BackGroundTask().execute("");
    }
    private class BackGroundTask extends AsyncTask<String, Void, String>{

        TableLayout table;
        ArrayList<String> data;
        @Override
        protected String doInBackground(String... params){
            this.data = getSQLData();
            return null;
        }
        @Override
        protected void onPostExecute(String result){
            table = (TableLayout) findViewById(R.id.tablelayout_JonSteveApartment);

            TableRow row = new TableRow(JonSteveApartment.this);
            TextView col1 = new TextView(JonSteveApartment.this);
            TextView col2 = new TextView(JonSteveApartment.this);
            TextView col3 = new TextView(JonSteveApartment.this);

            col1.setPadding(10, 10, 10, 10);
            col2.setPadding(10, 10, 10, 10);
            col3.setPadding(10, 10, 10, 10);

            col1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            col2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            col3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);

            col1.setGravity(Gravity.CENTER);
            col2.setGravity(Gravity.CENTER);
            col3.setGravity(Gravity.CENTER);

            col1.setText("# of Connections");
            col2.setText("Date Recorded");
            col3.setText("Time Recorded");

            row.addView(col1);
            row.addView(col2);
            row.addView(col3);

            table.addView(row);

            for (int i = 0; i < data.size(); i++){
                row = new TableRow(JonSteveApartment.this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
                lp.setMargins(4, 4, 4, 4);

                String [] entry = data.get(i).split(" ");

                col1 = new TextView(JonSteveApartment.this);
                col2 = new TextView(JonSteveApartment.this);
                col3 = new TextView(JonSteveApartment.this);

                col1.setPadding(10, 10, 10, 10);
                col2.setPadding(10, 10, 10, 10);
                col3.setPadding(10, 10, 10, 10);

                col1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
                col2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
                col3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);

                col1.setGravity(Gravity.CENTER);
                col2.setGravity(Gravity.CENTER);
                col3.setGravity(Gravity.CENTER);

                String users = entry[0];
                String date = entry[1];
                String time = entry[2];

                col1.setText(users);
                col2.setText(date);
                col3.setText(time);

                row.addView(col1);
                row.addView(col2);
                row.addView(col3);

                table.addView(row);
            }
            System.out.println(table.getChildCount());
        }
        public ArrayList<String> getSQLData(){
            int sum = 0;
            int count = 0;
            int storage = 0;
            String timestamp = "";
            ArrayList<String> history = new ArrayList<String>();

            try{
                //Class.forName("com.mysql.cj.jdbc.Driver");

                Connection myConn = DriverManager.getConnection("jdbc:mysql://capstone2019.cpayr1ebu9xg.us-east-2.rds.amazonaws.com:3306/rucrowded", "administrator" , "capstone2019");
                if (myConn == null){
                    String ConnectionResult = "Verify connection";
                    Toast.makeText(JonSteveApartment.this, ConnectionResult, Toast.LENGTH_LONG).show();
                    return null;
                }

                Statement myStatement = myConn.createStatement();
                ResultSet myResults = myStatement.executeQuery("SELECT * FROM DataCollection ORDER BY Timestamp DESC LIMIT 50;");

                while(myResults.next()){
                    history.add(myResults.getInt("Devices") + " " + myResults.getString("Timestamp"));
                    //System.out.println(myResults.getInt("Devices")+"," + myResults.getString("Timestamp"));
                    sum = sum + myResults.getInt("Devices");
                    storage = myResults.getInt("Devices");
                    timestamp = myResults.getString("Timestamp");
                    count++;
                }
            }
            catch(Exception exc){
                exc.printStackTrace();
            }
            if (count == 0){
                count = 1;
            }
            int avg = sum/count;
            System.out.println("The average number of users on the network is: " + avg + " users");
            System.out.println("The last scan on the network was conducted at: " + timestamp +" with " + storage + " users");
            System.out.println("Historical Data:\n#Users\tTimeStamp");

            return history;
        }

    }

}
