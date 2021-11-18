package com.example.jam_azan2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
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

import java.text.SimpleDateFormat;
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

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

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        String currentTime = simpleDateFormat.format(calendar.getTime());

        switchSubuh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(subuhMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Subuh")
                                .setContentText("Telah masuk waktu Subuh bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Subuh bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });

        switchSyuruk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(syurukMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Syuruk")
                                .setContentText("Telah masuk waktu Syuruk bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Syuruk bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });

        switchZohor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(zohorMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Zohor")
                                .setContentText("Telah masuk waktu Zohor bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Zohor bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });

        switchAsar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(asarMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Asar")
                                .setContentText("Telah masuk waktu Asar bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Asar bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });

        switchMaghrib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(maghribMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Maghrib")
                                .setContentText("Telah masuk waktu Maghrib bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Maghrib bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });

        switchIsyak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(currentTime.equals(insyakMasa)) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifikasi_Activity.this, "My Notification")
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Isyak")
                                .setContentText("Telah masuk waktu Isyak bagi kawasan Kuala Lumpur & sewaktu dengannya.")
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText("Telah masuk waktu Isyak bagi kawasan Kuala Lumpur & sewaktu dengannya."))
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManager notificationManager = (NotificationManager)
                                getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, builder.build());
                    }
                }
            }
        });
    }

    public void openSettings() {
        onBackPressed();
    }
}