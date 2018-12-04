package com.example.ashrafhussain.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    private static final String TAG = "ViewData";
    TextView name;
    DB_Helper db_helper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        db_helper = new DB_Helper(this);

        listView = findViewById(R.id.listview);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = db_helper.getdatalist();
        ArrayList<String> List = new ArrayList<>();
            while (data.moveToNext()) {
                //get the value from the database in column 1
                //then add it to the ArrayList
                List.add(data.getString(1));
            }
        //create the list adapter and set the adapter
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, List);
                listView.setAdapter(listAdapter);

        //set an onItemClickListener to the ListView
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String name = adapterView.getItemAtPosition(position).toString();
                        Log.d(TAG, "onItemClick: You Clicked on " + name);

                        //get the id associated with that name
                        Cursor data = db_helper.getItemID(name);
                        Log.d(TAG, "data " + data.toString());
                        int itemID = -1;
                        while (data.moveToNext()) {
                            itemID = data.getInt(0);
                        }
                        if (itemID > -1) {
                            Log.d(TAG, "onItemClick: The ID is: " + itemID);

                            Intent editScreenIntent = new Intent(ViewData.this, EditData.class);

                            editScreenIntent.putExtra("id", itemID);
                            editScreenIntent.putExtra("name", name);
                            startActivity(editScreenIntent);
                        } else {
                            Toast.makeText(ViewData.this, "No ID associated with that name", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
