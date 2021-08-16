package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UbahSlide extends Settings {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_slide1);

        Button to_settings = findViewById(R.id.to_settings);

        to_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openSettings() {
        Intent intent8 = new Intent(this, Settings.class);
        startActivity(intent8);
    }
}