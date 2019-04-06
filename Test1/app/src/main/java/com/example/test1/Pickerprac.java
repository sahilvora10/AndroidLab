package com.example.test1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Pickerprac extends AppCompatActivity {

    Button btnDatePicker;
    Button btnTimePicker;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker);
         btnDatePicker=(Button)findViewById(R.id.btndate);
         btnTimePicker=(Button)findViewById(R.id.btntime);

    }

public void dateClick(View v) {
    if (v == btnDatePicker) {


        final Calendar c = Calendar.getInstance();
        int mYear, mMonth, mDay;
        final EditText date1 = (EditText) findViewById(R.id.date1);
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date1.setText(dayOfMonth + " " + month + " " + year);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}

public void timeClick(View v)
{
    if(v == btnTimePicker)
    {   final EditText time1 = (EditText)findViewById(R.id.time1);
        final int mHour, mMinute;
        Calendar c = Calendar.getInstance();
        mHour=c.get(Calendar.HOUR);
        mMinute=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time1.setText(hourOfDay + " : " + minute);
            }
        },mHour,mMinute,false);
        timePickerDialog.show();
    }
}
}
