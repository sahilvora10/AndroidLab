package com.example.student.myapplication;

/**
 * Created by student on 11-Jan-19.
 */

import android.support.v7.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity{
    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.new_activity);

        text = (TextView)findViewById(R.id.textnew);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText("Welcome " + str);
    }
}
