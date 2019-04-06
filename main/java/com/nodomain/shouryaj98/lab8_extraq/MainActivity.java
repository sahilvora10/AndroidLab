package com.nodomain.shouryaj98.lab8_extraq;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> a;
    ListView lv;
    ActionMode am;
    ArrayAdapter aa;
    int sel = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a = new ArrayList<>(Arrays.asList("hi","hello"));
        a.add("GGG");
        lv = findViewById(R.id.lv);

        aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(aa);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lv.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                sel = position;
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                if(item.getItemId() == R.id.delete && sel!=-1)
                {
                   aa.remove(a.get(sel));
                }
                else
                {
                    aa.remove(a.get(sel));
                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    View promptView = layoutInflater.inflate(R.layout.textinp, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setView(promptView);

                    final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
                    // setup a dialog window
                    alertDialogBuilder.setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(MainActivity.this, "ds", Toast.LENGTH_SHORT).show();
                                    aa.add(editText.getText().toString());
                                }
                            })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                    // create an alert dialog
                    AlertDialog alert = alertDialogBuilder.create();
                    alert.show();
                }

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                sel = -1;
            }
        });
    }

}
