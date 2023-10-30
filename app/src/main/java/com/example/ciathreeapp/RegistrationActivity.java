package com.example.ciathreeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationActivity extends AppCompatActivity {

    private EditText nameEditText, ageEditText, phoneNumberEditText, mailIdEditText, aadharEditText, addressEditText;
    private EditText registrationNumberEditText, employeeIdEditText, customerIdEditText, dateTimeEditText;
    private Button registerButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        mailIdEditText = findViewById(R.id.mailIdEditText);
        aadharEditText = findViewById(R.id.aadharEditText);
        addressEditText = findViewById(R.id.addressEditText);

        registrationNumberEditText = findViewById(R.id.registrationNumberEditText);
        employeeIdEditText = findViewById(R.id.employeeIdEditText);
        customerIdEditText = findViewById(R.id.customerIdEditText);
        dateTimeEditText = findViewById(R.id.dateTimeEditText);

        registerButton = findViewById(R.id.registerButton);

    //Task 2
        // Generate registration number, employee ID, and customer ID (for demonstration purposes)
        String registrationNumber = "Reg" + System.currentTimeMillis();
        String employeeId = "Emp" + System.nanoTime();
        String customerId = "Cust" + System.nanoTime();

        // Get current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date());

        // Display generated values
        registrationNumberEditText.setText("Registration Number: " + registrationNumber);
        employeeIdEditText.setText("Employee ID: " + employeeId);
        customerIdEditText.setText("Customer ID: " + customerId);
        dateTimeEditText.setText("Date and Time: " + dateTime);

        dbHelper = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                String phone = phoneNumberEditText.getText().toString();
                String email = mailIdEditText.getText().toString();
                String aadhaar = aadharEditText.getText().toString();
                String address = addressEditText.getText().toString();

                // Insert data into the database
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_NAME, name);
                values.put(DatabaseHelper.COLUMN_AGE, age);
                values.put(DatabaseHelper.COLUMN_PHONE, phone);
                values.put(DatabaseHelper.COLUMN_EMAIL, email);
                values.put(DatabaseHelper.COLUMN_AADHAAR, aadhaar);
                values.put(DatabaseHelper.COLUMN_ADDRESS, address);

                long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);
                db.close();

                if (newRowId != -1) {
                    Toast.makeText(RegistrationActivity.this, "Saved Successfully", Toast.LENGTH_LONG).show();
                } else {
                    // Insert failed
                    Toast.makeText(RegistrationActivity.this, "Could not save the record", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
