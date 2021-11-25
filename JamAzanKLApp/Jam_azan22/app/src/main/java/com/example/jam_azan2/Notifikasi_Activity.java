package com.example.jam_azan2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Notifikasi_Activity extends AppCompatActivity {

    //initialize switchCompat
    SwitchCompat switchSubuh;
    SwitchCompat switchSyuruk;
    SwitchCompat switchZohor;
    SwitchCompat switchAsar;
    SwitchCompat switchMaghrib;
    SwitchCompat switchIsyak;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        Button to_settings2 = findViewById(R.id.to_settings2);

        //Assign Switch Var
        switchSubuh = findViewById(R.id.subuhswitch);
        switchSyuruk = findViewById(R.id.syurukswitch);
        switchZohor = findViewById(R.id.zohorswitch);
        switchAsar = findViewById(R.id.asarswitch);
        switchMaghrib = findViewById(R.id.maghribswitch);
        switchIsyak = findViewById(R.id.isyakswitch);


                //save switch state in shared preferences
                SharedPreferences sharedPreferences1 = getSharedPreferences("save1",MODE_PRIVATE);
                switchSubuh.setChecked(sharedPreferences1.getBoolean("value1",true));

                SharedPreferences sharedPreferences2 = getSharedPreferences("save2",MODE_PRIVATE);
                switchSyuruk.setChecked(sharedPreferences2.getBoolean("value2",true));

                SharedPreferences sharedPreferences3 = getSharedPreferences("save3",MODE_PRIVATE);
                switchZohor.setChecked(sharedPreferences3.getBoolean("value3",true));

                SharedPreferences sharedPreferences4 = getSharedPreferences("save4",MODE_PRIVATE);
                switchAsar.setChecked(sharedPreferences4.getBoolean("value4",true));

                SharedPreferences sharedPreferences5 = getSharedPreferences("save5",MODE_PRIVATE);
                switchMaghrib.setChecked(sharedPreferences5.getBoolean("value5",true));

                SharedPreferences sharedPreferences6 = getSharedPreferences("save6",MODE_PRIVATE);
                switchIsyak.setChecked(sharedPreferences6.getBoolean("value6",true));



                //Switch click Listener
                switchSubuh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchSubuh.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save1", MODE_PRIVATE).edit();
                            editor.putBoolean("value1", true);
                            editor.apply();
                            switchSubuh.setChecked(true);
                            startService(new Intent(getApplication(), ServiceSubuh.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save1", MODE_PRIVATE).edit();
                            editor.putBoolean("value1", false);
                            editor.apply();
                            switchSubuh.setChecked(false);
                        }
                    }
                });

                switchSyuruk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchSyuruk.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save2", MODE_PRIVATE).edit();
                            editor.putBoolean("value2", true);
                            editor.apply();
                            switchSyuruk.setChecked(true);
                            startService(new Intent(getApplication(), ServiceSyuruk.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save2", MODE_PRIVATE).edit();
                            editor.putBoolean("value2", false);
                            editor.apply();
                            switchSyuruk.setChecked(false);
                        }
                    }
                });

                switchZohor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchZohor.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save3", MODE_PRIVATE).edit();
                            editor.putBoolean("value3", true);
                            editor.apply();
                            switchZohor.setChecked(true);
                            startService(new Intent(getApplication(), ServiceZohor.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save3", MODE_PRIVATE).edit();
                            editor.putBoolean("value3", false);
                            editor.apply();
                            switchZohor.setChecked(false);
                        }
                    }
                });

                switchAsar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchAsar.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save4", MODE_PRIVATE).edit();
                            editor.putBoolean("value4", true);
                            editor.apply();
                            switchAsar.setChecked(true);
                            startService(new Intent(getApplication(), ServiceAsar.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save4", MODE_PRIVATE).edit();
                            editor.putBoolean("value4", false);
                            editor.apply();
                            switchAsar.setChecked(false);
                        }
                    }
                });

                switchMaghrib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchMaghrib.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save5", MODE_PRIVATE).edit();
                            editor.putBoolean("value5", true);
                            editor.apply();
                            switchMaghrib.setChecked(true);
                            startService(new Intent(getApplication(), ServiceMaghrib.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save5", MODE_PRIVATE).edit();
                            editor.putBoolean("value5", false);
                            editor.apply();
                            switchMaghrib.setChecked(false);
                        }
                    }
                });

                switchIsyak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchIsyak.isChecked()){
                            SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                            editor.putBoolean("value6", true);
                            editor.apply();
                            switchIsyak.setChecked(true);
                            startService(new Intent(getApplication(), ServiceIsyak.class));
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                            editor.putBoolean("value6", false);
                            editor.apply();
                            switchIsyak.setChecked(false);
                        }
                    }
                });

        to_settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }


    public void openSettings() {
        onBackPressed();
    }
}