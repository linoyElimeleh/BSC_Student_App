package com.example.class3demo2;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StudentDetails extends AppCompatActivity {
    List<Student> data;
    Student currentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_view);

        // Search the student in the list
        String nameStudent = getIntent().getStringExtra("student_name");
        //  String nameStudent="name 1"
        data = Model.instance.getAllStudents();
        //Optional<Student> studentToShow = (data.stream().filter(x -> x.getName() == nameStudent).findFirst());
        //todo chek what if we have more then one
        // currentStudent = studentToShow.get();


    }
}