package com.example.recandsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText name=findViewById(R.id.editText);
        final EditText place=findViewById(R.id.editText2);
        Button save=findViewById(R.id.button3);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textvar=name.getText().toString();
                String textvar2=place.getText().toString();
                DbHelper dbHelper=new DbHelper(getApplicationContext());
                dbHelper.insertUserDetails(textvar,textvar2);
            }
        });

    }

}
