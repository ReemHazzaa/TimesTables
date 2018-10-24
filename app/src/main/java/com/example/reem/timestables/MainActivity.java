package com.example.reem.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    SeekBar timesTablesSeekBar;
    TextView seekBarTextView;


    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTablesContent = new ArrayList<>();

        int timesTablesCounts = 100;
        for(int c=1; c<= timesTablesCounts; c++){
            timesTablesContent.add(Integer.toString(c * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, timesTablesContent);

        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);
        timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        seekBarTextView = findViewById(R.id.seekBarTextView);

        int startingPoint = 10;
        int max = 20;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPoint);

        generateTimesTable(startingPoint);


        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(progress < min){
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }else{
                    timesTableNumber = progress;
                }
                seekBarTextView.setText("TimesTables Number " + Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
