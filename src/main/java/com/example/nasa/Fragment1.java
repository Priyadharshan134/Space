package com.example.nasa;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class Fragment1 extends Fragment{
    BarChart sleep;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment1_layout,container,false);
        sleep = v.findViewById(R.id.sleepchart);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final String cDate = String.valueOf(simpleDateFormat.format(date));
        final String user = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        final FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
        DatabaseReference usernode = rootnode.getReference(user).child("sleep").child(cDate);
            usernode.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    long day = (long) snapshot.child("day").getValue();
                        long sleephr = (long) snapshot.child("time").getValue();
                        long defaultsleep;
                        if (day < 6) {
                            defaultsleep = 8;
                        } else if (day < 12) {
                            defaultsleep = 6;
                        } else {
                            defaultsleep = 9;
                        }

                        XAxis xAxis = sleep.getXAxis();
                        YAxis Right = sleep.getAxisRight();
                        Right.setEnabled(false);
                        YAxis Left = sleep.getAxisLeft();
                        Legend l = sleep.getLegend();
                        l.setWordWrapEnabled(true);
                        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
                        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
                        Left.setStartAtZero(true);

                        xAxis.setDrawGridLines(false);
                        Description description = sleep.getDescription();
                        description.setEnabled(false);
                        xAxis.setEnabled(false);
                        float barWidth = 9f;
                        float spaceForBar = 10f;
                        sleep.getAxisLeft().setAxisMinimum(0);
                        sleep.getAxisLeft().setAxisMaximum(10);
                        BarDataSet set1, set2;
                        ArrayList<IBarDataSet> dataSets = new ArrayList<>();

                        ArrayList<BarEntry> values1 = new ArrayList<>();
                        values1.add(new BarEntry(0 * spaceForBar, defaultsleep));
                        set1 = new BarDataSet(values1, "default sleep");
                        dataSets.add(set1);
                        set1.setColor(Color.RED);

                        ArrayList<BarEntry> values2 = new ArrayList<>();
                        values2.add(new BarEntry(1 * spaceForBar, sleephr));
                        set2 = new BarDataSet(values2, "actual sleep");
                        dataSets.add(set2);
                        set2.setColor(Color.RED);

                        BarData data = new BarData(dataSets);

                        Left.setValueFormatter(new ValueFormatter() {
                            @Override
                            public String getFormattedValue(float value) {
                                return String.valueOf((int) Math.floor(value));
                            }
                        });

                        Left.setAxisMinimum(0f);
                        Left.setAxisMaximum(10);
                        data.setBarWidth(barWidth);
                        sleep.setFitBars(true);
                        sleep.setData(data);
                    }

                @SuppressLint("RestrictedApi")
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        return v;
    }
}
