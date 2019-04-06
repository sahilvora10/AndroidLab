package com.example.myapplication;



        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;

/**
 * Created by student on 22-Feb-19.
 */

public class second_activity extends AppCompatActivity {
    TextView text1, text2,text3,text4,text5,text6,text7;
    Button back;
    LinearLayout main1, main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("src");
        String str2 = intent.getStringExtra("dst");
        String str3 = intent.getStringExtra("o_r");
        String str4 = intent.getStringExtra("d_date");
        String str5 = intent.getStringExtra("r_date");
        String str6 = intent.getStringExtra("name");
        String str7 = intent.getStringExtra("aadhar");

        text1.setText("Source: " + str1);
        text2.setText("Destination: "  + str2);
        text3.setText("Type of Trip: " +str3);
        text4.setText("Journey Date: " +str4);
        text5.setText("Arrival Date: " +str5);
        text6.setText("Name: " + str6);
        text7.setText("Aadhar Number: " +str7);



    }
}