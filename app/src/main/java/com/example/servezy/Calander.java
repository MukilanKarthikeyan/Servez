package com.example.servezy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

public class Calander extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";
    private CalendarView calender;
    TextView date_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        calender = (CalendarView) findViewById(R.id.calendarView);
        date_view = (TextView) findViewById(R.id.date_view);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year+"."+(month+1)+"."+dayOfMonth;
                date_view.setText(date);
            }
        });


    }
}
