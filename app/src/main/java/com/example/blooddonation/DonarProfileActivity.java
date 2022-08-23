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

public class DonarProfileActivity extends AppCompatActivity {
    private TextView donar_name;
    private EditText firstName, lastName, pwd, email, number,city;
    private Spinner country;
    private Button update, clear, log_out;
    String up_country, username;;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_profile);
        DonorDB db = new DonorDB(this);
        intent = getIntent();
        username = intent.getStringExtra(loginActivity.EXTRA_TEXT);

        donar_name = (TextView)findViewById(R.id.donar_name);
        donar_name.setText(username);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        pwd = findViewById(R.id.pwd);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        city = findViewById(R.id.city);
        country = findViewById(R.id.donar_country);

        update = findViewById(R.id.update);
        clear = findViewById(R.id.clear);
        log_out = findViewById(R.id.log_out);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_country = country.getSelectedItem().toString();
                db.updateDonarProfile(firstName.getText().toString(),lastName.getText().toString(), pwd.getText().toString(), email.getText().toString(), number.getText().toString(), city.getText().toString(), up_country, username);
                Toast.makeText(getApplicationContext(),"Updated sucessfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DonarProfileActivity.this, DonarProfileActivity.class);
                startActivity(intent);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText(" ");
                lastName.setText(" ");
                email.setText(" ");
                pwd.setText(" ");
                city.setText(" ");
                number.setText(" ");
            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonarProfileActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });
    }




}