package com.example.ticketbooking;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import java.util.Calendar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.content.Intent;
        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.app.DatePickerDialog;
        import android.app.TimePickerDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.RadioButton;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.RadioGroup;
        import android.widget.EditText;
        import android.widget.TimePicker;
        import java.text.DateFormat;
        import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
        import java.util.ArrayList;
        import java.util.List;
        import android.support.v7.app.AlertDialog;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText tb1;
    EditText tb2;
    String o_r;
    TextView rtn_dt;
    Button btnDatePicker,rtn_btnDatePicker;
    EditText txtDate,txtDate1;
    private int mYear, mMonth, mDay, mHour, mMinute;
    ToggleButton togg;
    //String currentDateString = DateFormat.getDateInstance().format(new Date());

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Calendar c = Calendar.getInstance();
    String currentDateString = sdf.format(c.getTime());


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb1 = (EditText)findViewById(R.id.enterText);
        tb2 = (EditText)findViewById(R.id.enterText1);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        togg=(ToggleButton)findViewById(R.id.toggleButton);
        rtn_btnDatePicker=(Button)findViewById(R.id.rtn_btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtDate1=(EditText)findViewById(R.id.rtn_date);
        rtn_dt=(TextView)findViewById(R.id.rtn_text);
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Button button=(Button)findViewById(R.id.button);
        Button clrbt =(Button)findViewById(R.id.clrbt);

        // Spinner click listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Delhi");
        categories.add("Kolkata");
        categories.add("Mumbai");
        categories.add("Bangalore");
        categories.add("Hyderabad");
        categories.add("Chennai");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner1.setAdapter(dataAdapter);



        togg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean ToggleButtonState = togg.isChecked();
                if(ToggleButtonState==true && getCurrentTime(v).compareTo("22:00")<=0)
                {
                    button.setClickable(false);
                    Toast.makeText(getApplicationContext(), "TATKAL can be booked only after 11PM ", Toast.LENGTH_LONG).show();


                }
                else
                    button.setClickable(true);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = tb1.getText().toString();
                String str2 = tb2.getText().toString();
                String d_date = txtDate.getText().toString();
                String r_date = txtDate1.getText().toString();
                o_r= togg.getText().toString();
                Intent intent= new Intent(MainActivity.this,second_activity.class);
                intent.putExtra("src",String.valueOf(spinner.getSelectedItem()));
                intent.putExtra("dst",String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("o_r", o_r);
                intent.putExtra("d_date", d_date);
                intent.putExtra("r_date", r_date);
                intent.putExtra("name", str1);
                intent.putExtra("aadhar", str2);
                startActivity(intent);
            }
        });

        clrbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tb1.setText("");
                tb2.setText("");
                txtDate.setText(currentDateString);
                txtDate1.setText(getCurrentTime(v));

            }
        });



    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    public String getCurrentTime(View view) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm");
        String strDate =  mdformat.format(calendar.getTime());
        return  strDate;
    }

    public void dateClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }}


    public void rtndateClick(View v) {

        if (v == rtn_btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtDate1.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }}
}





