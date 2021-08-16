package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifikasi extends Settings{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        Button to_settings2 = findViewById(R.id.to_settings2);

        to_settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openSettings() {
        Intent intent7 = new Intent(this, Settings.class);
        startActivity(intent7);
    }
}