package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Intent intent=getIntent();
        String str=intent.getStringExtra("src");
        String arr[]=str.split(" ");
        TextView tv = (TextView)findViewById(R.id.tv21);
        TextView tv1 = (TextView)findViewById(R.id.tv22);
        tv.setText("");
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i].contains("abc"))
            {
                tv.append(arr[i]);
                tv.append(" ");
            }
        }
        Arrays.sort(arr);
        tv1.setText(Arrays.toString(arr));

    }

    public void backbtn(View v){
        finish();
    }
}
