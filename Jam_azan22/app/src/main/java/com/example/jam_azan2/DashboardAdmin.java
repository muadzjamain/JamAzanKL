package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }

    public void openSettings() {
        Intent intent = new Intent(this, AdminSettings_Activity.class);
        startActivity(intent);
    }

}