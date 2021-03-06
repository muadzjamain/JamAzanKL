package com.example.jam_azan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class UpdatePassword extends AppCompatActivity {

    private Button update, toSettings;
    private EditText newPassword;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        update=findViewById(R.id.btnUpdatePassword);
        newPassword=findViewById(R.id.etNewPassword);
        toSettings = (Button)findViewById(R.id.to_settings);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userPasswordNew= newPassword.getText().toString();
                firebaseUser.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UpdatePassword.this, "Kata Laluan Telah Diubah", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(UpdatePassword.this, "Kata Laluan Gagal Diubah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        toSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}