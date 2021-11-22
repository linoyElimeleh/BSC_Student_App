package com.example.class3demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class StudentEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_edit);

        Intent intent = getIntent();

        // edit name
        String name = intent.getStringExtra("name");
        EditText editedName = findViewById(R.id.sde_value_name);
        editedName.setText(name);

        // edit id
        String id = intent.getStringExtra("id");
        EditText editedId = findViewById(R.id.sde_value_id);
        editedId.setText(id);

        // edit phone
        String phone = intent.getStringExtra("phone");
        EditText editedPhone = findViewById(R.id.sde_value_phone);
        editedPhone.setText(phone);

        // edit address
        String address = intent.getStringExtra("add");
        EditText editedAddress = findViewById(R.id.sde_value_add);
        editedAddress.setText(address);

        // checkbox address
        String check = intent.getStringExtra("check");
        CheckBox editedCheck = findViewById(R.id.checkBox);
        editedCheck.setText(check);

        // Import old student
        Student oldStudent = new Student(name, id, address, phone, Boolean.parseBoolean(check));

        // Click on cancel
        Button cancelButton = findViewById(R.id.sd_edit_cancel);
        Intent intentDetails = new Intent(this, StudentDetails.class);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDetails);
            }
        });

        // Click on save
        Button saveButton = findViewById(R.id.sd_edit_save);
        Intent intentDetailsWithExtra = new Intent(this, StudentDetails.class);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student newStudent = new Student(editedName.getText().toString(), editedId.getText().toString(),
                        editedAddress.getText().toString(), editedPhone.getText().toString(), editedCheck.getFreezesText());
                Model.instance.updateStudent(oldStudent, newStudent);

                intentDetailsWithExtra.putExtra("name", editedName.getText().toString());
                intentDetailsWithExtra.putExtra("id", editedId.getText().toString());
                intentDetailsWithExtra.putExtra("add", editedAddress.getText().toString());
                intentDetailsWithExtra.putExtra("phone", editedPhone.getText().toString());
                intentDetailsWithExtra.putExtra("check", editedCheck.isChecked());

                startActivity(intentDetailsWithExtra);

            }
        });

        // Click on delete
        Button deleteButton = findViewById(R.id.sd_edit_delete);
        Intent intentDelete = new Intent(this, StudentListActivity.class);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.instance.deleteStudent(oldStudent);
                startActivity(intentDelete);
            }
        });

    }


}