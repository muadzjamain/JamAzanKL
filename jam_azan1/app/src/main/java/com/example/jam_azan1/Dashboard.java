package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Login {
    private Button to_settings1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        to_settings1 = (Button) findViewById(R.id.to_settings1);
        to_settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}