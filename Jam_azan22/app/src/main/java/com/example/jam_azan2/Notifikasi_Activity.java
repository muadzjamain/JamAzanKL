package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Notifikasi_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        Button to_settings2 = findViewById(R.id.to_settings2);

        Switch switchSubuh = findViewById(R.id.subuhswitch);
        Switch switchSyuruk = findViewById(R.id.syurukswitch);
        Switch switchZohor = findViewById(R.id.zohorswitch);
        Switch switchAsar = findViewById(R.id.asarswitch);
        Switch switchMaghrib = findViewById(R.id.maghribswitch);
        Switch switchIsyak = findViewById(R.id.isyakswitch);

        to_settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        switchSubuh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
                else{

                }
            }
        });
    }

    public void openSettings() {
        onBackPressed();
    }
}