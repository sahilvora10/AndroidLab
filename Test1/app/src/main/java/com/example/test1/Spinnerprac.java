package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spinnerprac extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        Intent intent = getIntent();
        String srl=intent.getStringExtra("sr");
        String narr[]=srl.toString().split(" ");
        Arrays.sort(narr);
        List<String> cat1= Arrays.asList(narr);


        Spinner spinner = (Spinner)findViewById(R.id.spin1);
        Spinner spinner2 = (Spinner)findViewById(R.id.spin2);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);

        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)this);
        List<String> cat = new ArrayList<String>();
        cat.add("hello");
        cat.add("name");
        cat.add("nice");
        ArrayAdapter<String> da = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cat);
        da.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> da2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cat1);
        da2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(da);
        spinner2.setAdapter(da2);




    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
