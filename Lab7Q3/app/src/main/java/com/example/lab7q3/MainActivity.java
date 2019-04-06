package com.example.lab7q3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonHome);
        final ImageView im1=(ImageView)findViewById(R.id.simpleImage1);
        final ImageView im2=(ImageView)findViewById(R.id.simpleImage2);
        final ImageView im3=(ImageView)findViewById(R.id.simpleImage3);
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
                                im1.setVisibility(View.VISIBLE);
                                im2.setVisibility(View.GONE);
                                im3.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "One selected", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.menu_2:
                                im2.setVisibility(View.VISIBLE);
                                im1.setVisibility(View.GONE);
                                im3.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Two selected", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.menu_3:
                                im3.setVisibility(View.VISIBLE);
                                im1.setVisibility(View.GONE);
                                im2.setVisibility(View.GONE);
                                Toast.makeText(MainActivity.this, "Three selected", Toast.LENGTH_SHORT).show();
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
