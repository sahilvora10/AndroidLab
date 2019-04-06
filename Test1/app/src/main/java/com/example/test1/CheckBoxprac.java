package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBoxprac extends AppCompatActivity {
    CheckBox checkbox;
    String[] narr;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        Intent intent = getIntent();
        final Button cbutton=(Button)findViewById(R.id.btncheck);
        String list = intent.getStringExtra("list");
        LinearLayout linear = (LinearLayout) findViewById(R.id.linear1);
        final LinearLayout linear2 = (LinearLayout) findViewById(R.id.linear2);
        narr = list.split(" ");
        final Context mcontext = this;



        final List<CheckBox> lCheckBox = new ArrayList<CheckBox>();
        for (int i = 0; i < narr.length; i++) {
            checkbox = new CheckBox(this);
            linear.addView(checkbox);
            checkbox.setText(narr[i]);
            lCheckBox.add(checkbox);
        }

        cbutton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                PopupMenu popupMenu= new PopupMenu(CheckBoxprac.this,v);
                popupMenu.inflate(R.menu.popmenu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        ArrayList<String> checka = new ArrayList<String>();
                        ArrayList<String> uchecka = new ArrayList<String>();
                        checka.clear();
                        for(int j=0;j<lCheckBox.size();j++)
                        {
                            if(lCheckBox.get(j).isChecked())
                            {
                                checka.add(lCheckBox.get(j).getText().toString());

                            }
                            else
                            {
                                uchecka.add(lCheckBox.get(j).getText().toString());
                            }

                        }


                        ListView listView1 = new ListView(CheckBoxprac.this);


                        switch (item.getItemId())
                        {
                            case R.id.chck:
                                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(CheckBoxprac.this, android.R.layout.simple_list_item_1,checka);
                                listView1.setAdapter(arrayAdapter);
                                linear2.removeAllViews();
                                linear2.addView(listView1);
                                return true;

                            case R.id.unchk:
                                ArrayAdapter<String> arrayAdapter2= new ArrayAdapter<String>(CheckBoxprac.this, android.R.layout.simple_list_item_1,uchecka);
                                listView1.setAdapter(arrayAdapter2);
                                linear2.removeAllViews();
                                linear2.addView(listView1);
                                return true;

                                default:
                                    return true;
                        }


                    }
                });
popupMenu.show();

            }
        });



    }

}
