package com.example.jam_azan2;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class DashboardUser extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button to_settings1;
    private FirebaseDatabase firebaseDatabase;


    private TextView subuhMasa;
    private TextView syurukMasa;
    private TextView zohorMasa;
    private TextView asarMasa;
    private TextView maghribMasa;
    private TextView insyakMasa;

    Calendar dateCalendar= Calendar.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://jam-azan-kl-2-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private String DatabaseDate = android.text.format.DateFormat.format("ddMMyyyy",dateCalendar).toString();
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        subuhMasa= findViewById(R.id.time_subuh2);
        syurukMasa=findViewById(R.id.time_Syuruk2);
        zohorMasa=findViewById(R.id.time_zohor2);
        asarMasa=findViewById(R.id.time_asar2);
        maghribMasa=findViewById(R.id.time_maghrib2);
        insyakMasa=findViewById(R.id.time_insyak2);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference("DataAzan/" + DatabaseDate);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Subuh1 = (String) dataSnapshot.child("Subuh").getValue();
                String syuruk1 = (String) dataSnapshot.child("Syuruk").getValue();
                String zohor1 = (String) dataSnapshot.child("Zohor").getValue();
                String asar1 = (String) dataSnapshot.child("Asar").getValue();
                String maghrib1 = (String) dataSnapshot.child("Maghrib").getValue();
                String insyak1 = (String) dataSnapshot.child("Isyak").getValue();
//
//                Toast.makeText(DashboardUser.this, Subuh1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(DashboardUser.this, syuruk1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(DashboardUser.this, zohor1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(DashboardUser.this, asar1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(DashboardUser.this, maghrib1, Toast.LENGTH_SHORT).show();
//                Toast.makeText(DashboardUser.this, insyak1, Toast.LENGTH_SHORT).show();
//
                subuhMasa.setText(Subuh1);
                syurukMasa.setText(syuruk1);
                zohorMasa.setText(zohor1);
                asarMasa.setText(asar1);
                maghribMasa.setText(maghrib1);
                insyakMasa.setText(insyak1);;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Gagal untuk membaca data", error.toException());
            }
        });


        String languageToLoad  = "ms"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
//        this.setContentView(R.layout.activity_dashboard_user);

        Calendar calendar= Calendar.getInstance();
        String currentDate= android.text.format.DateFormat.format("d MMMM yyyy",calendar).toString();
        TextView textViewDate = findViewById(R.id.normal_date);
        textViewDate.setText(currentDate);

        Calendar date = Calendar.getInstance();
        String dayToday = android.text.format.DateFormat.format("EEEE", date).toString();
        TextView myTextView = findViewById(R.id.day);
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
        TextView AZANView = findViewById(R.id.islamic_date);
        AZANView.setText(islamicDate);

//        Calendar islamic = Calendar.getInstance();
//        String islamicDate = android.text.format.DateFormat.format("dd MMMM yyyy", islamic).toString();
//        TextView AZANView = findViewById(R.id.islamic_date);
//        AZANView.setText(islamicDate);

        firebaseAuth = FirebaseAuth.getInstance();

        to_settings1 = (Button) findViewById(R.id.to_settings1);
        to_settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }


    public void openSettings() {
        Intent intent = new Intent(this, UserSettings_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}

