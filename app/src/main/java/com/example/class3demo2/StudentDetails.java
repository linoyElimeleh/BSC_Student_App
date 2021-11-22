package com.example.class3demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;


public class StudentDetails extends AppCompatActivity {
    List<Student> data;
    Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_view);
        Button editButton= findViewById(R.id.sd_edit_btn);

        TextView name_value=findViewById(R.id.sd_value_name);
        TextView id_value=findViewById(R.id.sd_value_id);
        TextView address_value=findViewById(R.id.sd_value_add);
        TextView phone_value=findViewById(R.id.sd_value_phone);
        CheckBox check_value=findViewById(R.id.sd_checkBox);

        Intent intent= new Intent(this,StudentEdit.class);

        intent.putExtra("name",name_value.getText().toString());
        intent.putExtra("id",id_value.getText().toString());
        intent.putExtra("add",address_value.getText().toString());
        intent.putExtra("phone",phone_value.getText().toString());
        intent.putExtra("check",check_value.isChecked());

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });




        // Search the student in the list
        String nameStudent = getIntent().getStringExtra("student_name");
        //  String nameStudent="name 1"
        data = Model.instance.getAllStudents();
        //Optional<Student> studentToShow = (data.stream().filter(x -> x.getName() == nameStudent).findFirst());
        //todo chek what if we have more then one
        // currentStudent = studentToShow.get();


    }
}