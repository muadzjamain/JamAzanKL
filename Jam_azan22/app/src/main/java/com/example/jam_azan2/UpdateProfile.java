package com.example.jam_azan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class UpdateProfile extends AppCompatActivity {

    private EditText newUserName, newUserEmail;
    private Button save, toSettings1;
//    private FirebaseAuth firebaseAuth;
//    private FirebaseDatabase firebaseDatabase;
    private ImageView updateProfilePic;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://jam-azan-kl-2-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
//    private static int PICK_IMAGE = 123;
//    Uri imagePath;
//    private StorageReference storageReference;
//    private FirebaseStorage firebaseStorage;


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
//            imagePath = data.getData();
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
//                updateProfilePic.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        newUserName = findViewById(R.id.etNameUpdate);
        newUserEmail = findViewById(R.id.etEmailUpdate);
        toSettings1 = findViewById(R.id.to_settings4);
        save = findViewById(R.id.btnSave);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        firebaseAuth= FirebaseAuth.getInstance();
//        firebaseDatabase= FirebaseDatabase.getInstance();

        //get data once
        databaseReference.child("Users").child(UID).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            } else {
                //Log.d("firebase", String.valueOf(task.getResult().getValue()));
                UserProfile userData = Objects.requireNonNull(task.getResult()).getValue(UserProfile.class);
                assert userData != null;
                newUserName.setText(userData.getUserName());
                newUserEmail.setText(userData.getUserEmail());
                //add get profile image example provided below
                //profilePicture.setImageURI(userData.getProfilePicture());
                //to use this, u need to modify usermodel class by adding this
                //private Uri profilePicture;
                //public usermodel(....., Uri profilePicture){
                //......;
                // this.profilePicture = profilePicture;
                //}
                //public Uri getProfilePicture(){ return profilePicture;}
            }
        });

//        final DatabaseReference databaseReference= firebaseDatabase.getReference(firebaseAuth.getUid());
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
//                newUserName.setText(userProfile.getUserName());
//                newUserEmail.setText(userProfile.getUserEmail());
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(UpdateProfile.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
//
//            }
//        });

        toSettings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                }
            });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newUserName.getText().toString().isEmpty() || newUserEmail.getText().toString().isEmpty()) {
                Toast.makeText(UpdateProfile.this, "One or Many fields are empty.", Toast.LENGTH_SHORT).show();
                return;
            }

            final String email = newUserEmail.getText().toString();
            user.updateEmail(email).addOnSuccessListener(unused -> {
                Toast.makeText(UpdateProfile.this, "Email is changed.", Toast.LENGTH_SHORT).show();
                //update database after done update email
                databaseReference.child("Users").child(UID).child("userName").setValue(newUserName.getText().toString());
                databaseReference.child("Users").child(UID).child("userEmail").setValue(email);
                Toast.makeText(UpdateProfile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                finish();
            }).addOnFailureListener(e -> Toast.makeText(UpdateProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        });

    }
}