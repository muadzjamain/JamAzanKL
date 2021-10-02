package com.example.jam_azan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.util.Calendar;

public class DashboardUser extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button to_settings1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        Calendar calendar= Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.normaldateid);
        textViewDate.setText(currentDate);

        Calendar date = Calendar.getInstance();
        String dayToday = android.text.format.DateFormat.format("EEEE", date).toString();
        TextView myTextView = findViewById(R.id.dayid);
        myTextView.setText(dayToday);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.book:
//                        startActivity(new Intent(getApplicationContext()
//                                , DashBoard.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                    case R.id.home:h
//                        return true;
//                    case R.id.about:
//                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//                        return true;
//                }
//                return false;
//
//            }
//        });

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
    }

//    private void Logout() {
//        firebaseAuth.signOut();
//        finish();
//        startActivity(new Intent(DashboardUser.this, Login_Activity.class));
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.logoutMenu: {
//                Logout();
//            }
//            case R.id.profileMenu:
//                startActivity(new Intent(DashboardUser.this, ProfileActivity.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
}