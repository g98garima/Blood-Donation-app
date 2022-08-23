package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DonarRegistrationActivity extends AppCompatActivity {
    private TextView goBack;
    private Button register, clear;
    private EditText fname, lname, uname, pwd, email, city,phone_number;
    private Spinner country, gen, bloodtype, usertype;
    String regis_country, gender, blood_type, user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_registration);

        register = findViewById(R.id.donar_regisBtn);
        clear = findViewById(R.id.donar_regis_clearBtn);
        goBack = findViewById(R.id.goBack);
        fname = findViewById(R.id.donar_regis_fname);
        lname = findViewById(R.id.donar_regis_lname);
        uname = findViewById(R.id.donar_regis_username);
        pwd = findViewById(R.id.donar_regis_pwd);
        email = findViewById(R.id.donar_regis_email);
        city = findViewById(R.id.donar_regis_city);
        phone_number = findViewById(R.id.donar_regis_number);

        country = (Spinner)findViewById(R.id.donar_regis_country);
        gen = (Spinner)findViewById(R.id.donar_regis_gender);
        bloodtype = (Spinner)findViewById(R.id.donar_regis_blood_type);
        usertype = (Spinner)findViewById(R.id.user_type);


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonarRegistrationActivity.this, loginActivity.class);
                startActivity(intent);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis_country  = country.getSelectedItem().toString();
                gender = gen.getSelectedItem().toString();
                blood_type = bloodtype.getSelectedItem().toString();
                user_type = usertype.getSelectedItem().toString();

                if(fname.getText().toString().trim().equals("")|| lname.getText().toString().trim().equals("")|| uname.getText().toString().trim().equals("")|| pwd.getText().toString().trim().equals("")|| email.getText().toString().trim().equals("")|| phone_number == null){
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

                }else {

                    DonorDB databaseHelper = new DonorDB(DonarRegistrationActivity.this);

                    databaseHelper.createNewDonor(fname.getText().toString(), lname.getText().toString(), uname.getText().toString(), pwd.getText().toString(), email.getText().toString(), phone_number.getText().toString(), city.getText().toString(), regis_country, gender, blood_type, user_type);
                    Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DonarRegistrationActivity.this, loginActivity.class);
                    startActivity(intent);
                }
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
}