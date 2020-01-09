package com.example.recandsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        List<Users> users = new ArrayList<Users>();

        DbHelper dbHelper = new DbHelper(this);
        Cursor cursor = dbHelper.getUserDetails();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(dbHelper.col_Name));
            String place = cursor.getString(cursor.getColumnIndex(dbHelper.col_Place));
            Log.d("hamk", "name= " + name + "place= " + place);
            users.add(new Users(name, place));
        }
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(users));

    }
}
