package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slidechange extends AppCompatActivity {
    private Button to_profil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidechange);

        to_profil2=findViewById(R.id.to_profil2);
        to_profil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent51 = new Intent(Slidechange.this, UbahSlide_Activity.class);
                startActivity(intent51);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });




    }
}