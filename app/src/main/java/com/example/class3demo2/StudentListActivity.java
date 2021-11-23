package com.example.class3demo2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    List<Student> data;
    Intent intentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance.getAllStudents();
        intentDetails = new Intent(this, StudentDetails.class);
        MyAdapter adapter = new MyAdapter();

        ListView listv = findViewById(R.id.studentlist_listv);
        listv.setAdapter(adapter);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "row was clicked" + position);

        FloatingActionButton plusStudent = findViewById(R.id.sl_add_btn);
        Intent intentMainActivity = new Intent(this, StudentAddNew.class);
        plusStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMainActivity);
            }
        });

        TextView studentName = findViewById(R.id.listrow_name_tv);

//        studentName.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String currentName = "";
//                String currentId = "";
//
//                //intentDetailsWithExtra.putExtra("name", editedName.getText().toString());
//                //intentDetailsWithExtra.putExtra("id", editedId.getText().toString());
//
//            }
//        });

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.student_list_row, null);
                CheckBox cb = convertView.findViewById(R.id.listrow_cb);
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = Integer.parseInt(v.getTag().toString());
                        Log.d("TAG", "cbn position " + pos);
                        Student s = data.get(pos);
                        s.setFlag(cb.isChecked());
                    }
                });

                TextView studentName = convertView.findViewById(R.id.listrow_name_tv);
                studentName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = Integer.parseInt(v.getTag().toString());
                        Log.d("Student", "Student " + pos);
                        Student s = data.get(pos);
                        String studentsName = s.getName();
                        String studentsId = s.getId();
                        Student studentToShow = Model.instance.findTheStudent(studentsName, studentsId);
                        intentDetails.putExtra("name", studentToShow.getName());
                        intentDetails.putExtra("id", studentToShow.getId());
                        intentDetails.putExtra("phone", studentToShow.getPhone());
                        intentDetails.putExtra("add", studentToShow.getAddress());
                        intentDetails.putExtra("check", studentToShow.isFlag());
                        startActivity(intentDetails);
                    }
                });
            }
            TextView studentId = convertView.findViewById(R.id.listrow_id_tv);
            studentId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = Integer.parseInt(v.getTag().toString());
                    Log.d("Student", "Student " + pos);
                    Student s = data.get(pos);
                    String studentsName = s.getName();
                    String studentsId = s.getId();
                    Student studentToShow = Model.instance.findTheStudent(studentsName, studentsId);
                    intentDetails.putExtra("name", studentToShow.getName());
                    intentDetails.putExtra("id", studentToShow.getId());
                    intentDetails.putExtra("phone", studentToShow.getPhone());
                    intentDetails.putExtra("add", studentToShow.getAddress());
                    intentDetails.putExtra("check", studentToShow.isFlag());
                    startActivity(intentDetails);
                }
            });


            TextView nameTv = convertView.findViewById(R.id.listrow_name_tv);
            TextView idTv = convertView.findViewById(R.id.listrow_id_tv);
            CheckBox cb = convertView.findViewById(R.id.listrow_cb);
            cb.setTag(position);
            nameTv.setTag(position);
            idTv.setTag(position);

            Student student = data.get(position);
            nameTv.setText(student.getName());
            idTv.setText(student.getId());

            cb.setChecked(student.isFlag());
            return convertView;
        }
    }
}