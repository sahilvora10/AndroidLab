package com.example.student.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (EditText)findViewById(R.id.enterText);
        final Button button=(Button)findViewById(R.id.firstButton);
        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str = tb.getText().toString();
                if(!(((EditText) findViewById(R.id.enterText)).getText().toString().equals("admin")&& ((EditText) findViewById(R.id.enterText1)).getText().toString().equals("admin")))
                {
                    builder.setMessage("Wrong Credentials!").setTitle("Error").setPositiveButton("Okay",null).show();
                }
                else
                {
                    Intent myIntent = new Intent(MainActivity.this,
                            secondActivity.class);
                    myIntent.putExtra("message", str);
                    startActivity(myIntent);
                }

            }
        });
    }
}
