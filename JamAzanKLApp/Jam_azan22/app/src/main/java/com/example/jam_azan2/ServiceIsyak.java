package com.example.jam_azan2;

import static android.content.ContentValues.TAG;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServiceIsyak extends Service {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    Calendar dateCalendar= Calendar.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://jam-azan-kl-2-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private String DatabaseDate = android.text.format.DateFormat.format("ddMMyyyy",dateCalendar).toString();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

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
                String insyak1 = (String) dataSnapshot.child("Isyak").getValue();

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
                String currentTime = simpleDateFormat.format(calendar.getTime()).toUpperCase();

                if(currentTime.equals(insyak1)) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(ServiceIsyak.this, "My Notification")
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

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Gagal untuk membaca data", error.toException());
            }
        });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
