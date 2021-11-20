package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class MainActivity extends AppCompatActivity {
    EditText nameEt;
    EditText idEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.main_name_et);
        idEt = findViewById(R.id.main_id_et);
        cb = findViewById(R.id.main_cb);
        Button saveBtn = findViewById(R.id.main_save_btn);
        Button cancelBtn = findViewById(R.id.main_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String name = nameEt.getText().toString();
        String id = idEt.getText().toString();
        boolean flag = cb.isChecked();
        Model.instance.addStudent(new Student(name, id, flag));
        Log.d("TAG", "saved name:" + name + " id:" + id + " flag:" + flag);

        // Go to the student view
        // setContentView(R.layout.activity_student_list);
        Intent intent = new Intent(this, StudentDetails.class);
        intent.putExtra("student_name", new String(name));
        startActivity(intent);
    }
}