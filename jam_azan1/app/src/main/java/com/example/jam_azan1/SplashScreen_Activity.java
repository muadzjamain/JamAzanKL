package com.example.jam_azan1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen_Activity extends AppCompatActivity {

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mRunnable = new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getApplication(), Login_Activity.class));
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable,2000);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mHandler != null && mRunnable != null)
            mHandler.removeCallbacks(mRunnable);
    }

}
