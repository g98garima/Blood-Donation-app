package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private TextView signUp;
    private Button signInButton;
    private EditText username, pwd;
    public static final String EXTRA_TEXT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        pwd = findViewById(R.id.registerPassword);

        signInButton = findViewById(R.id.signInButton);
        signUp = findViewById(R.id.signUp);



        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DonorDB databaseHelper = new DonorDB(loginActivity.this);


                Boolean  loginRecipient= databaseHelper.recipientLogin(username.getText().toString(), pwd.getText().toString());
                Boolean  loginDonar= databaseHelper.donarLogin(username.getText().toString(), pwd.getText().toString());

                if (loginRecipient == true){
                    Toast.makeText(getApplicationContext(), "Username found", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this,  ProfileInfoActivity.class);
                    intent.putExtra(EXTRA_TEXT, username.getText().toString());
                    startActivity(intent);

                }else if(loginDonar == true){
                    Toast.makeText(getApplicationContext(), "Username found", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this,  DonarProfileActivity.class);
                    intent.putExtra(EXTRA_TEXT, username.getText().toString());
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Username not found", Toast.LENGTH_SHORT).show();
                }


            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, DonarRegistrationActivity.class);
                startActivity(intent);
            }
        });


    }
}