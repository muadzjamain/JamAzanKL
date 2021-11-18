package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Slidechange extends AppCompatActivity {
    private Button to_profil2;
    private Button picture1;
    private Button picture2;
    private Button picture3;
    private Button picture4;
    private Button picture5;
    private Button picture6;

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
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        picture1=findViewById(R.id.pic1);
        picture2=findViewById(R.id.pic2);
        picture3=findViewById(R.id.pic3);
        picture4=findViewById(R.id.pic4);
        picture5=findViewById(R.id.pic5);
        picture6=findViewById(R.id.pic6);




    }
}