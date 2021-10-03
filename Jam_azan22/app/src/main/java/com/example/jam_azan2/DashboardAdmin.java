package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class DashboardAdmin extends AppCompatActivity {

    private Button to_settings1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        to_settings1 = (Button) findViewById(R.id.to_settings1);
        to_settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
        Calendar calendar= Calendar.getInstance();
        String currentDate= android.text.format.DateFormat.format("dd MMMM yyyy",calendar).toString();
        TextView textViewDate = findViewById(R.id.normal_date);
        textViewDate.setText(currentDate);

        Calendar date = Calendar.getInstance();
        String dayToday = android.text.format.DateFormat.format("EEEE", date).toString();
        TextView myTextView = findViewById(R.id.day);
        myTextView.setText(dayToday);

        Calendar islamic = Calendar.getInstance();
        Locale locale = new Locale( "JA" , "JP" ) ;
        String islamicDate = android.text.format.DateFormat.format("dd MMMM yyyy", islamic).toString();
        TextView AZANView = findViewById(R.id.islamic_date);
        AZANView.setText(islamicDate);

    }

    public void openSettings() {
        Intent intent = new Intent(this, AdminSettings_Activity.class);
        startActivity(intent);
    }

}