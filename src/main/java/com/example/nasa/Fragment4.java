package com.example.nasa;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class Fragment4 extends Fragment{
    private String launch,landing,docking,fromiss,toiss,layover;
    private TextInputEditText elaunch,elanding,edocking,efromiss,etoiss,elayover;
    private Button eventsbt;
    private static long day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4_layout,container,false);
        elaunch = v.findViewById(R.id.launch);
        elanding = v.findViewById(R.id.landing);
        edocking = v.findViewById(R.id.docking);
        efromiss = v.findViewById(R.id.fromiss);
        etoiss = v.findViewById(R.id.toiss);
        elayover = v.findViewById(R.id.layover);
        eventsbt = v.findViewById(R.id.eventsbt);

   /*     eventsbt.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View v) {
                launch = elaunch.getText().toString();
             landing = elanding.getText().toString();
             docking = edocking.getText().toString();
             fromiss = efromiss.getText().toString();
             toiss = etoiss.getText().toString();
             layover = elayover.getText().toString();

             Date date = new Date();
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
             final String cDate = String.valueOf(simpleDateFormat.format(date));
             final String user = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
             final FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
             final DatabaseReference node = rootnode.getReference(user).child(user+cDate);
             final String push = node.push().getKey().toString();
             node.child(cDate).setValue(push);

             final DatabaseReference usernode = rootnode.getReference(user).child("events").child(cDate);
             node.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                     long day = snapshot.getChildrenCount() ;
                     Eventco eventco = new Eventco(launch,landing,docking,fromiss,toiss,layover);
                     usernode.setValue(eventco);
                 }

                 @SuppressLint("RestrictedApi")
                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {
                     Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                 }
             });

            }
        });*/
        return v;

    }
}
