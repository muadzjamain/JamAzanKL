package com.example.jam_azan2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Notifikasi_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    private String subuhMasa;
    private String syurukMasa;
    private String zohorMasa;
    private String asarMasa;
    private String maghribMasa;
    private String insyakMasa;

    Calendar dateCalendar= Calendar.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://jam-azan-kl-2-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private String DatabaseDate = android.text.format.DateFormat.format("ddMMyyyy",dateCalendar).toString();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        Button to_settings2 = findViewById(R.id.to_settings2);

        Switch switchSubuh = findViewById(R.id.subuhswitch);
        Switch switchSyuruk = findViewById(R.id.syurukswitch);
        Switch switchZohor = findViewById(R.id.zohorswitch);
        Switch switchAsar = findViewById(R.id.asarswitch);
        Switch switchMaghrib = findViewById(R.id.maghribswitch);
        Switch switchIsyak = findViewById(R.id.isyakswitch);

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

                subuhMasa = Subuh1;
                syurukMasa = syuruk1;
                zohorMasa = zohor1;
                asarMasa = asar1;
                maghribMasa = maghrib1;
                insyakMasa = insyak1;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Gagal untuk membaca data", error.toException());
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        to_settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        switchSubuh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
                else{

                }
            }
        });
    }

    public void openSettings() {
        onBackPressed();
    }
}