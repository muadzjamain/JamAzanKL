package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class UserSettings_Activity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);

        Button to_main1 = findViewById(R.id.to_main1);
        TextView to_editprofile = findViewById(R.id.to_editprofile);
        TextView to_ubahslide = findViewById(R.id.to_ubahslide);
        TextView to_notifikasi1 = findViewById(R.id.to_notifikasi);
        TextView to_derma1 = findViewById(R.id.to_derma);
        TextView to_tentangkami = findViewById(R.id.to_tentangkami);
        TextView to_logout = findViewById(R.id.to_logout);


        to_main1.setOnClickListener((View.OnClickListener) this);
        to_editprofile.setOnClickListener((View.OnClickListener) this);
        to_ubahslide.setOnClickListener((View.OnClickListener) this);
        to_notifikasi1.setOnClickListener((View.OnClickListener) this);
        to_derma1.setOnClickListener((View.OnClickListener) this);
        to_tentangkami.setOnClickListener((View.OnClickListener) this);
        to_logout.setOnClickListener((View.OnClickListener) this);
    }

    private void Logout() {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(UserSettings_Activity.this, Login_Activity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_main1:
                onBackPressed();
                break;
            case R.id.to_editprofile:
                Intent intent15 = new Intent(this, ProfileActivity.class);
                startActivity(intent15);
                break;
            case R.id.to_ubahslide:
                Intent intent2 = new Intent(this, UbahSlide_Activity.class);
                startActivity(intent2);
                break;
            case R.id.to_notifikasi:
                Intent intent3 = new Intent(this, Notifikasi_Activity.class);
                startActivity(intent3);
                break;
            case R.id.to_derma:
                Intent intent4 = new Intent(this, Derma_Activity.class);
                startActivity(intent4);
                break;
            case R.id.to_tentangkami:
                Intent intent5 = new Intent(this, TentangKami_Activity.class);
                startActivity(intent5);
                break;
            case R.id.to_logout:
                Logout();
                break;
        }
    }

}