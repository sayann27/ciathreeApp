package com.example.ciathreeapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RetrieveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DatabaseHelper(this);

        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataAdapter(this, fetchDataFromDatabase());
        recyclerView.setAdapter(adapter);
    }

    private List<DataItem> fetchDataFromDatabase() {
        List<DataItem> dataItemList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE));
                // Retrieve other fields as needed and create a DataItem object
                DataItem dataItem = new DataItem(name, age);
                dataItemList.add(dataItem);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return dataItemList;
    }
}
