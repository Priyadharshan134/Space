package com.example.nasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Collectionip extends AppCompatActivity {

    private TextInputEditText ename,egender,eage,ehypnotic,ealertness,echronobiology;
    private Button ipsubmit;
    private String  name,gender,age,hypnotic,alertness,chronobiology;
    private String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
    private DatabaseReference usernode = rootnode.getReference();

   protected void onStart() {
        super.onStart();
        usernode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String root = ds.getKey().toString();
                    if(user.contentEquals(root)){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("userid",root);
                        startActivity(intent);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectionip);

        ename = findViewById(R.id.edtInput1);
        egender = findViewById(R.id.edtInput2);
        eage = findViewById(R.id.edtInput3);
        ehypnotic = findViewById(R.id.edtInput4);
        ealertness = findViewById(R.id.edtInput5);
        echronobiology = findViewById(R.id.edtInput6);
        ipsubmit =findViewById(R.id.btnSbt);

        ipsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                gender = egender.getText().toString();
                age = eage.getText().toString();
                hypnotic = ehypnotic.getText().toString();
                alertness = ealertness.getText().toString();
                chronobiology = echronobiology.getText().toString();


                rootnode = FirebaseDatabase.getInstance();
                usernode = rootnode.getReference(user).child("primary");

                Collectorip collectorip = new Collectorip(name,gender,age,hypnotic,alertness,chronobiology);
                usernode.setValue(collectorip);

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
    }
}