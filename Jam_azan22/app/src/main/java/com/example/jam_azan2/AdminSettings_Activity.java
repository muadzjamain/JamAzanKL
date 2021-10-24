package com.example.jam_azan2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class AdminSettings_Activity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_admin);

        String languageToLoad  = "ms"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_settings_admin);

        Calendar calendar= Calendar.getInstance();
        String currentDate= android.text.format.DateFormat.format("d MMMM yyyy",calendar).toString();
        TextView textViewDate = findViewById(R.id.normal_date2);
        textViewDate.setText(currentDate);

        Calendar date = Calendar.getInstance();
        String dayToday = android.text.format.DateFormat.format("EEEE", date).toString();
        TextView myTextView = findViewById(R.id.day2);
        myTextView.setText(dayToday);

        ///
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar islamicMonth1 = Calendar.getInstance();
        String islamicMonth2= android.text.format.DateFormat.format("MM",islamicMonth1).toString();
        int monthOfYear = Integer.parseInt(islamicMonth2);
        int year = calendar.get(Calendar.YEAR);

        LocalDate dt = LocalDate.of(year, monthOfYear, dayOfMonth);
        HijrahDate hijrahDate = HijrahDate.from(dt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        String islamicDate = formatter.format(hijrahDate); // 07/03/1439
        TextView AZANView = findViewById(R.id.islamic_date2);
        AZANView.setText(islamicDate);

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
        startActivity(new Intent(AdminSettings_Activity.this, Login_Activity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_main1:
                Intent intent17 = new Intent(this, DashboardAdmin.class);
                startActivity(intent17);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.to_editprofile:
                Intent intent15 = new Intent(this, ProfileActivity.class);
                startActivity(intent15);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.to_ubahslide:
                Intent intent2 = new Intent(this, UbahSlide_Activity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.to_notifikasi:
                Intent intent3 = new Intent(this, Notifikasi_Activity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.to_derma:
                Intent intent4 = new Intent(this, Derma_Activity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.to_tentangkami:
                Intent intent5 = new Intent(this, TentangKami_Activity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.to_logout:
                Logout();
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}