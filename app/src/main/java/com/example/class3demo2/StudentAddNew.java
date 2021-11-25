package com.example.class3demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class StudentAddNew extends AppCompatActivity {
    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("New Students");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        // Initialize buttons
        nameEt = findViewById(R.id.main_name_et);
        idEt = findViewById(R.id.main_id_et);
        phoneEt = findViewById(R.id.main_phone_et);
        addressEt = findViewById(R.id.main_add_et);
        cb = findViewById(R.id.main_cb);

        // Save action
        Button saveBtn = findViewById(R.id.main_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        // Cancel action
        Button cancelBtn = findViewById(R.id.main_cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void cancel() {
        Intent intent = new Intent(this, StudentListActivity.class);
        startActivity(intent);
    }

    private void save() {

        // Get data
        String name = nameEt.getText().toString();
        String id = idEt.getText().toString();
        String phone = phoneEt.getText().toString();
        String add = addressEt.getText().toString();
        boolean flag = cb.isChecked();

        // Add new student to the model instance
        Model.instance.addStudent(new Student(name, id, add, phone, flag));
        Log.d("TAG", "saved name:" + name + " id:" + id + " flag:" + flag);

        // Create new intent with data to the next page
        Intent intent = new Intent(this, StudentListActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("id", id);
        intent.putExtra("add", add);
        intent.putExtra("phone", phone);
        intent.putExtra("check", flag);

        // Go to the student details view
        startActivity(intent);
    }
}