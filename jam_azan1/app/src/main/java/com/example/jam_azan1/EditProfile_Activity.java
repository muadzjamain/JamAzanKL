package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditProfile_Activity extends Settings_Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Button to_settings4 = findViewById(R.id.to_settings4);
        Button to_editprof= findViewById(R.id.to_editprof);
        Button to_changepass= findViewById(R.id.to_changepass);

        to_settings4.setOnClickListener(this);
        to_editprof.setOnClickListener(this);
        to_changepass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.to_settings4:
                Intent intent10 = new Intent(this, Settings_Activity.class);
                startActivity(intent10);
                break;
            case R.id.to_editprof:
                Intent intent11 = new Intent(this, UbahSlide_Activity.class);
                startActivity(intent11);
                break;
            case R.id.to_notifikasi1:
                Intent intent12 = new Intent(this, Notifikasi_Activity.class);
                startActivity(intent12);
                break;
        }
    }
}
