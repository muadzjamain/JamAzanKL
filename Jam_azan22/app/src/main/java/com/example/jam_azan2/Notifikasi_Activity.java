package com.example.jam_azan2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    //initialize switchCompat
    SwitchCompat switchSubuh;
    SwitchCompat switchSyuruk;
    SwitchCompat switchZohor;
    SwitchCompat switchAsar;
    SwitchCompat switchMaghrib;
    SwitchCompat switchIsyak;

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

        //Assign Switch Var
        switchSubuh = findViewById(R.id.subuhswitch);
        switchSyuruk = findViewById(R.id.syurukswitch);
        switchZohor = findViewById(R.id.zohorswitch);
        switchAsar = findViewById(R.id.asarswitch);
        switchMaghrib = findViewById(R.id.maghribswitch);
        switchIsyak = findViewById(R.id.isyakswitch);

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

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
                String currentTime = simpleDateFormat.format(calendar.getTime()).toUpperCase();


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

                            if(currentTime.equals(Subuh1)) {
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

                            if(currentTime.equals(syuruk1)) {
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

                            if(currentTime.equals(zohor1)) {
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

                            if(currentTime.equals(asar1)) {
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

                            if(currentTime.equals(maghrib1)) {
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

                            if(currentTime.equals(insyak1)) {
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
                        }else {
                            SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                            editor.putBoolean("value6", false);
                            editor.apply();
                            switchIsyak.setChecked(false);
                        }
                    }
                });
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
    }

    public void openSettings() {
        onBackPressed();
    }
}