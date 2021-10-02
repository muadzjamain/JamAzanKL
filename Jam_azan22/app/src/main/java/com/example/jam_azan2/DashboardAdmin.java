package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

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
        String currentDate= DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.normaldateid);
        textViewDate.setText(currentDate);

        Calendar date = Calendar.getInstance();
        String dayToday = android.text.format.DateFormat.format("EEEE", date).toString();
        TextView myTextView = findViewById(R.id.dayid);
        myTextView.setText(dayToday);

    }

    public void openSettings() {
        Intent intent = new Intent(this, AdminSettings_Activity.class);
        startActivity(intent);
    }

}