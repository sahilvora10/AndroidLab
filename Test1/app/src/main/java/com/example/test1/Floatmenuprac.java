package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Floatmenuprac extends AppCompatActivity {
    String[] str_l;
    ArrayAdapter<String> arrayAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floatmenu);
        Intent intent=getIntent();
        String str=intent.getStringExtra("list");
        ListView listView= (ListView)findViewById(R.id.listv);

        str_l=str.toString().split(" ");
        arrayAdapter= new ArrayAdapter<String>(Floatmenuprac.this,android.R.layout.simple_list_item_1,str_l);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.context,menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.clr:
                String s=str_l[adapterContextMenuInfo.position];
                Toast.makeText(Floatmenuprac.this,"CLEAR "+s,Toast.LENGTH_SHORT).show();


                return true;

            case R.id.edit:
                Toast.makeText(Floatmenuprac.this,"EDIT",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return true;
        }
    }
}
