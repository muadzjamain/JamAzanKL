package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings_Activity extends Dashboard_Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button to_main1 = findViewById(R.id.to_main1);
        Button to_editprofile = findViewById(R.id.to_editprofile);
        Button to_ubahslide= findViewById(R.id.to_ubahslide1);
        Button to_notifikasi1= findViewById(R.id.to_notifikasi1);
        Button to_derma1= findViewById(R.id.to_derma1);
        Button to_tentangkami= findViewById(R.id.to_tentangkami);


        to_main1.setOnClickListener(this);
        to_editprofile.setOnClickListener(this);
        to_ubahslide.setOnClickListener(this);
        to_notifikasi1.setOnClickListener(this);
        to_derma1.setOnClickListener(this);
        to_tentangkami.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.to_main1:
                Intent intent1 = new Intent(this, Dashboard_Activity.class);
                startActivity(intent1);
                break;
            case R.id.to_editprofile:
                Intent intent9 = new Intent(this, EditProfile_Activity.class);
                startActivity(intent9);
                break;
            case R.id.to_ubahslide1:
                Intent intent2 = new Intent(this, UbahSlide_Activity.class);
                startActivity(intent2);
                break;
            case R.id.to_notifikasi1:
                Intent intent3 = new Intent(this, Notifikasi_Activity.class);
                startActivity(intent3);
                break;
            case R.id.to_derma1:
                Intent intent4 = new Intent(this, Derma_Activity.class);
                startActivity(intent4);
                break;
            case R.id.to_tentangkami:
                Intent intent5 = new Intent(this, TentangKami_Activity.class);
                startActivity(intent5);
                break;
        }
    }
}