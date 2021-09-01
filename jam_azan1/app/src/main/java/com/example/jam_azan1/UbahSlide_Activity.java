package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UbahSlide_Activity extends Settings_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_slide1);

        Button to_settings4 = findViewById(R.id.to_settings4);

        to_settings4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openSettings() {
        Intent intent8 = new Intent(this, Settings_Activity.class);
        startActivity(intent8);
    }
}