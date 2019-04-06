package com.example.student.lab08;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class q1 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        initDB();

//        deleteUsers();
        getUsers();
    }

    private void deleteUsers() {
        db.execSQL("DELETE FROM contacts");
    }

    private void initDB() {
        db = openOrCreateDatabase("Test", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS contacts" +
                "(name VARCHAR, phone VARCHAR, email VARCHAR)");
    }

    public void getUsers() {
        Log.d(TAG, "getUsers: Get users");
        Cursor res = db.rawQuery("SELECT * FROM users", null);
        res.moveToFirst();
        while(res.moveToNext()){
            Log.d(TAG, "getUsers: "+res.getString(0)+" "+res.getString(1));
        }
    }

    public void save(View view){
        
    }
}
