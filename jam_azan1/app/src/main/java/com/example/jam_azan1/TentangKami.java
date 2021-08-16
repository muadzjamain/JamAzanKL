package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TentangKami extends Settings {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kami);

        Button to_settings3 = findViewById(R.id.to_settings3);

        to_settings3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openSettings() {
        Intent intent6 = new Intent(this, Settings.class);
        startActivity(intent6);
    }
}