package com.example.jam_azan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class UserSettings_Activity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);

        Button to_main1 = findViewById(R.id.to_main1);
        TextView to_editprofile = findViewById(R.id.to_editprofile);
        TextView to_ubahslide= findViewById(R.id.to_ubahslide);
        TextView to_notifikasi1= findViewById(R.id.to_notifikasi1);
        TextView to_derma1= findViewById(R.id.to_derma1);
        TextView to_tentangkami= findViewById(R.id.to_tentangkami);
        TextView to_logout=findViewById(R.id.to_logout);


        to_main1.setOnClickListener((View.OnClickListener) this);
        to_editprofile.setOnClickListener((View.OnClickListener) this);
        to_ubahslide.setOnClickListener((View.OnClickListener) this);
        to_notifikasi1.setOnClickListener((View.OnClickListener) this);
        to_derma1.setOnClickListener((View.OnClickListener) this);
        to_tentangkami.setOnClickListener((View.OnClickListener) this);
    }
    private void Logout() {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(UserSettings_Activity.this, MainActivity.class));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_main1:
                Intent intent1 = new Intent(this, DashboardUser.class);
                startActivity(intent1);
                break;
            case R.id.to_editprofile:
                startActivity(new Intent(UserSettings_Activity.this, ProfileActivity.class));
                break;
            case R.id.to_ubahslide:
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
            case R.id.to_logout:
                Logout();
                break;
        }
    }


}