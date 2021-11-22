package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class StudentEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_edit);

        Intent intent =getIntent();
        String name= intent.getStringExtra("name");
        EditText editedName = findViewById(R.id.sde_value_name);
        editedName.setText(name);

        String id= intent.getStringExtra("id");
        EditText editedid = findViewById(R.id.sde_value_name);
        editedName.setText(name);


    }
}