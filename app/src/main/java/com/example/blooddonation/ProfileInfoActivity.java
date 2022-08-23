package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.stringtemplate.v4.ST;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProfileInfoActivity extends AppCompatActivity {
        private Button logout;
    DonorDB db;
    ListView list;
    ArrayAdapter adapter;
    String username;
    Intent intent;
    ArrayList<String> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        intent = getIntent();
        username = intent.getStringExtra(loginActivity.EXTRA_TEXT);

        TextView textview = (TextView)findViewById(R.id.user_name);
        textview.setText(username);

        logout = findViewById(R.id.log_out);
         db = new DonorDB(this);
         list = findViewById(R.id.donar_list);


        listItem = new ArrayList<>();
        viewData();


        logout.setOnClickListener(view -> {
             intent = new Intent(ProfileInfoActivity.this, loginActivity.class);
            startActivity(intent);
        });



    }
    private void viewData(){
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(ProfileInfoActivity.this, "No Data To show", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add("Name: "+cursor.getString(1) +" "+ cursor.getString(2) +"\n" + "Email: "+cursor.getString(5) + "\n" + "Phone Number: "+cursor.getString(6) +"\n" + "Blood Group: "+cursor.getString(10)+"\n") ;




            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            list.setAdapter(adapter);
        }
    }
}

