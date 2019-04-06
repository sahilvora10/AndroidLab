package com.example.test1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Floatactionprac extends AppCompatActivity {
    String[] str_l;
    int sel = -1;
    ArrayList<String> a;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floataction);


        Intent intent=getIntent();
        String str=intent.getStringExtra("list");


        ListView listView= (ListView)findViewById(R.id.listv);

        str_l=str.toString().split(" ");
        a= new ArrayList<String>(Arrays.asList(str_l));

        arrayAdapter= new ArrayAdapter<String>(Floatactionprac.this,android.R.layout.simple_list_item_1,a);
        listView.setAdapter(arrayAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                sel = position;
                Toast.makeText(Floatactionprac.this,"1",Toast.LENGTH_SHORT).show();


            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Toast.makeText(Floatactionprac.this,"2",Toast.LENGTH_SHORT).show();
                MenuInflater menuInflater1=getMenuInflater();
                menuInflater1.inflate(R.menu.action,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                Toast.makeText(Floatactionprac.this,"3",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if(item.getItemId()==R.id.del && sel!=-1)
                {
                    arrayAdapter.remove(a.get(sel));

                }
                else
                {
                    arrayAdapter.remove(a.get(sel));
                    LayoutInflater layoutInflater=LayoutInflater.from(Floatactionprac.this);
                    View promtview = layoutInflater.inflate(R.layout.textedit,null);
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(Floatactionprac.this);
                    alertbox.setView(promtview);
                    final EditText editText = (EditText) promtview.findViewById(R.id.edittext);
                    alertbox.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Floatactionprac.this,"EDIT",Toast.LENGTH_SHORT).show();
                            arrayAdapter.add(editText.getText().toString());

                        }
                    })
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Floatactionprac.this,"CANCEL",Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert = alertbox.create();
                    alert.show();
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                Toast.makeText(Floatactionprac.this, "5", Toast.LENGTH_SHORT).show();
                sel = -1;

            }
        });

    }
}
