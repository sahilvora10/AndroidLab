package com.example.lab7q4;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.view.menu.MenuPopupHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tx1=(TextView)findViewById(R.id.text1);
        tx1.setText("Demonetization is the act of stripping a currency unit of its status as legal tender.\n " +
                "It occurs whenever there is a change of national currency: The current form or forms of money " +
                "is pulled from circulation and retired,\n " +
                "often to be replaced with new notes or coins. \n " +
                "Sometimes, a country completely replaces the old currency with new currency.");
        ImageButton simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonHome);

        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Home Button", Toast.LENGTH_LONG).show();// display the toast on home button click
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.btn_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch(item.getItemId())
                        {
                            case R.id.menu_1:

                                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                                LayoutInflater li = LayoutInflater.from(context);
                                View promptsView = li.inflate(R.layout.prompts, null);
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                        context);

                                // set prompts.xml to alertdialog builder
                                alertDialogBuilder.setView(promptsView);
                                final EditText userInput = (EditText) promptsView
                                        .findViewById(R.id.editTextDialogUserInput);

                                alertDialogBuilder
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,int id) {
                                                        if(tx1.getText().toString().contains(userInput.getText().toString()))
                                                        {
                                                            Toast.makeText(MainActivity.this, "Text contains " + userInput.getText(), Toast.LENGTH_SHORT).show();
                                                        }
                                                        else
                                                        {
                                                            Toast.makeText(MainActivity.this, "Text does not contains " + userInput.getText(), Toast.LENGTH_SHORT).show();
                                                        }


                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,int id) {
                                                        dialog.cancel();
                                                    }
                                                });

                                AlertDialog alertDialog = alertDialogBuilder.create();

                                // show it
                                alertDialog.show();

                                return true;

                            case R.id.menu_2:

                                Toast.makeText(MainActivity.this, "Sort", Toast.LENGTH_SHORT).show();

                                String narr[] = tx1.getText().toString().split(" ");
                                Arrays.sort(narr);
                                tx1.setText(Arrays.toString(narr).replace(","," "));

                                return true;

                            case R.id.menu_3:

                                Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
                                tx1.setText("");
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
