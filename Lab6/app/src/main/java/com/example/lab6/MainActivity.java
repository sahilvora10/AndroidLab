package com.example.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String s = "Toast";
        switch(item.getItemId()){
            case R.id.iAdmission:
                showAdmission();
                s = "Admission";
                break;
            case R.id.iCourses:
                showCourses();
                s = "Courses";
                break;
            case R.id.iFaculty:
                showFaculty();
                s = "Faculty";
                break;
            case R.id.iShare:
                s = "Share";
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();

        return true;
    }

    private void showFaculty() {
        setContentView(R.layout.faculty);
    }

    private void showCourses() {
        setContentView(R.layout.courses);
    }

    private void showAdmission() {
        setContentView(R.layout.admission);
    }
}
