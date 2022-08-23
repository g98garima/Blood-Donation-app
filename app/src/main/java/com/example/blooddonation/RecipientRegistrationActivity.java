/*
package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RecipientRegistrationActivity extends AppCompatActivity {
    private TextView goBack;
    private Button register, clear;
    private EditText fname, lname, uname, pwd, email, city,phone_number;
    private Spinner country, gen, bloodtype;
    String regis_country, gender, blood_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_registration);

        clear = findViewById(R.id.recip_regis_clearBtn);
        register = findViewById(R.id.recip_regisBtn);
        goBack = findViewById(R.id.goBack);
        fname = findViewById(R.id.recip_regis_fname);
        lname = findViewById(R.id.recip_regis_lname);
        uname = findViewById(R.id.recip_regis_username);
        pwd = findViewById(R.id.recip_regis_pwd);
        email = findViewById(R.id.recip_regis_email);
        city = findViewById(R.id.recip_regis_city);
        phone_number = findViewById(R.id.recip_regis_number);
        country = (Spinner)findViewById(R.id.recip_regis_country);
        gen = (Spinner)findViewById(R.id.recip_regis_gender);
        bloodtype = (Spinner)findViewById(R.id.recip_regis_blood_type);

        */
/*Spinner mySpinner = (Spinner) findViewById(R.id.recip_regis_country);
        String country = mySpinner.getSelectedItem().toString();

        Spinner gender = (Spinner) findViewById(R.id.recip_regis_gender);
        String gen = gender.getSelectedItem().toString();
        Spinner Blood = (Spinner) findViewById(R.id.recip_regis_blood_type);
        String bloodtype = Blood.getSelectedItem().toString();*//*


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecipientRegistrationActivity.this, loginActivity.class);
                startActivity(intent);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                regis_country  = country.getSelectedItem().toString();
                gender = gen.getSelectedItem().toString();
                blood_type = bloodtype.getSelectedItem().toString();

                DonorDB databaseHelper = new DonorDB(RecipientRegistrationActivity.this);

                databaseHelper.createNewRecipient(fname.getText().toString(), lname.getText().toString(),uname.getText().toString(), pwd.getText().toString(), email.getText().toString(), phone_number.getText().toString(), city.getText().toString(), regis_country, gender, blood_type);
                Intent intent = new Intent(RecipientRegistrationActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname.setText(" ");
                lname.setText(" ");
                uname.setText(" ");
                pwd.setText(" ");
                email.setText(" ");
                city.setText(" ");
                phone_number.setText(" ");
            }
        });
    }
}*/
