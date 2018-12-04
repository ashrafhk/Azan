package com.example.ashrafhussain.sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DB_Helper db_helper;
    EditText e1;
    Button add, dataview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_helper = new DB_Helper(this);

        e1 = findViewById(R.id.Name);
        add = findViewById(R.id.Add);
        dataview = findViewById(R.id.View);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = e1.getText().toString();
                if (e1.length() != 0){
                    AddData(newEntry);
                    e1.setText("");
                }else {
                    Toast.makeText(getApplicationContext(), "Filled something!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dataview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewData.class);
                startActivity(intent);
            }
        });
    }

        public void AddData(String newEntry){

        boolean insertdata = db_helper.addData(newEntry);

        if (insertdata){
            Toast.makeText(getApplicationContext(), "Data is Inserted!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Data is not Inserted!", Toast.LENGTH_SHORT).show();
            }
        }

}
