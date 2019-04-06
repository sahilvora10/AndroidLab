package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
    }

    public void showMessage(View v){
        Toast.makeText(MainActivity.this,"SHOWING MESSAGE",Toast.LENGTH_SHORT).show();
        Intent it = new Intent(MainActivity.this,SecondActivity.class);
        final EditText et1 = (EditText)findViewById(R.id.et1);
        final String str=et1.getText().toString();
        it.putExtra("src",str);
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String s = " ";
        switch (item.getItemId())
        {
            case R.id.Spinner:
                spinner();
                s= "Spinner";
                break;

            case R.id.toggle:
                toggle();
                s="Toggle";
                break;
            case R.id.picker:
                picker();
                s="Picker";
                break;
            case R.id.menu:
                s="Choose a suboption";
                break;
            case R.id.cb:
                checkbox();
                s="Checkbox";
                break;
            case R.id.radio:
                radiobox();
                s="Radio Buttons";
                break;
            case R.id.floatm:
                floatmenu();
                s="Floating Menu";
                break;
            case R.id.floata:
                floataction();
                s="Floating Action";
                break;


        }
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();

        return true;
    }



    private void spinner()
    {
         Intent intents = new Intent(MainActivity.this,Spinnerprac.class);
        final EditText et1 = (EditText)findViewById(R.id.et1);
         intents.putExtra("sr",et1.getText().toString());
         startActivity(intents);
    }

    private  void toggle()
    {
        Intent intentt = new Intent(MainActivity.this,Toggleprac.class);
        startActivity(intentt);
    }

    private void picker()
    {
        Intent intentp = new Intent(MainActivity.this,Pickerprac.class);
        startActivity(intentp);
    }

    private void checkbox()
    {
        Intent intentc = new Intent(MainActivity.this,CheckBoxprac.class);
        final EditText et1 = (EditText)findViewById(R.id.et1);
        intentc.putExtra("list",et1.getText().toString());
        startActivity(intentc);
    }
    private void radiobox()
    {
    }


   private void floatmenu()
   {
       Intent intentf = new Intent(MainActivity.this,Floatmenuprac.class);
       final EditText et1 = (EditText)findViewById(R.id.et1);
       intentf.putExtra("list",et1.getText().toString());
       startActivity(intentf);

   }
   private void floataction()
   {
       Intent intentf = new Intent(MainActivity.this,Floatactionprac.class);

       final EditText et1 = (EditText)findViewById(R.id.et1);
       intentf.putExtra("list",et1.getText().toString());
       startActivity(intentf);
   }
}
