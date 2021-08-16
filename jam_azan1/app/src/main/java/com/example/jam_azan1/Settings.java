package com.example.jam_azan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends MainActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button to_main1 = findViewById(R.id.to_main1);
        Button to_ubahslide= findViewById(R.id.to_ubahslide);
        Button to_notifikasi1= findViewById(R.id.to_notifikasi1);
        Button to_derma1= findViewById(R.id.to_derma1);
        Button to_tentangkami= findViewById(R.id.to_tentangkami);


        to_main1.setOnClickListener(this);
        to_ubahslide.setOnClickListener(this);
        to_notifikasi1.setOnClickListener(this);
        to_derma1.setOnClickListener(this);
        to_tentangkami.setOnClickListener(this);



        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.to_main1:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.to_ubahslide:
                Intent intent2 = new Intent(this, UbahSlide.class);
                startActivity(intent2);
                break;
            case R.id.to_notifikasi1:
                Intent intent3 = new Intent(this, Notifikasi.class);
                startActivity(intent3);
                break;
            case R.id.to_derma1:
                Intent intent4 = new Intent(this, Derma.class);
                startActivity(intent4);
                break;
            case R.id.to_tentangkami:
                Intent intent5 = new Intent(this, TentangKami.class);
                startActivity(intent5);
                break;
        }
    }
}