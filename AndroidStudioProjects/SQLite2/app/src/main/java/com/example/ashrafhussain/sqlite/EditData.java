package com.example.ashrafhussain.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditData extends AppCompatActivity {

    private static final String TAG = "ViewData";

    DB_Helper db_helper;
    EditText e1;
    Button delete, update;
    private int selectedID;
    private String selectedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        db_helper = new DB_Helper(this);

        e1 = findViewById(R.id.EditName);
        delete = findViewById(R.id.Delete);
        update = findViewById(R.id.Update);

        //get the intent extra from the ViewDataActivity
        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value
        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");
        //set the text to show the current selected name
        e1.setText(selectedName);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = e1.getText().toString();
                if(!item.equals("")){
                    db_helper.updateName(item, selectedID, selectedName);
                    Toast.makeText(getApplicationContext(), "Updated sucessfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter something", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db_helper.deleteName(selectedID, selectedName);
                e1.setText("");
                Toast.makeText(getApplicationContext(), "Removed from database", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
