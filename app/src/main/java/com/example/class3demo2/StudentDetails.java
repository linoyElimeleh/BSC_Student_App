package com.example.class3demo2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class StudentDetails extends AppCompatActivity {
    List<Student> data;
    Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_view);

        //todo add this when we have the connection between student list and student details
        Intent oldIntent = getIntent();

        // edit name
        String name = oldIntent.getStringExtra("name");
        TextView editedName = findViewById(R.id.sd_value_name);
        editedName.setText(name);

        // edit id
        String id = oldIntent.getStringExtra("id");
        TextView editedId = findViewById(R.id.sd_value_id);
        editedId.setText(id);

        // edit phone
        String phone = oldIntent.getStringExtra("phone");
        TextView editedPhone = findViewById(R.id.sd_value_phone);
        editedPhone.setText(phone);

        // edit address
        String address = oldIntent.getStringExtra("add");
        TextView editedAddress = findViewById(R.id.sd_value_add);
        editedAddress.setText(address);

        // checkbox
        Boolean check = oldIntent.getBooleanExtra("check", false);
        CheckBox editedCheck = findViewById(R.id.sd_checkBox);
        editedCheck.setChecked(check);

        Button editButton = findViewById(R.id.sd_edit_btn);

        TextView name_value = findViewById(R.id.sd_value_name);
        TextView id_value = findViewById(R.id.sd_value_id);
        TextView address_value = findViewById(R.id.sd_value_add);
        TextView phone_value = findViewById(R.id.sd_value_phone);
        CheckBox check_value = findViewById(R.id.sd_checkBox);

        Intent intent = new Intent(this, StudentEdit.class);

        intent.putExtra("name", name_value.getText().toString());
        intent.putExtra("id", id_value.getText().toString());
        intent.putExtra("add", address_value.getText().toString());
        intent.putExtra("phone", phone_value.getText().toString());
        intent.putExtra("check", check_value.isChecked());

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}