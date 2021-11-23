package com.example.class3demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

public class StudentEdit extends AppCompatActivity {
    Intent intentDetailsWithExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_edit);
        this.setTitle("Edit Students");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        // Get previous data
        setTextViewWithPreviousItem(intent, "name", R.id.sde_value_name);
        setTextViewWithPreviousItem(intent, "id", R.id.sde_value_id);
        setTextViewWithPreviousItem(intent, "phone", R.id.sde_value_phone);
        setTextViewWithPreviousItem(intent, "add", R.id.sde_value_add);
        setCheckBoxWithPreviousItem(intent, "check", R.id.checkBox);

        // Get Data
        String name = intent.getStringExtra("name");
        EditText editedName = findViewById(R.id.sde_value_name);
        String id = intent.getStringExtra("id");
        EditText editedId = findViewById(R.id.sde_value_id);
        String phone = intent.getStringExtra("phone");
        EditText editedPhone = findViewById(R.id.sde_value_phone);
        String address = intent.getStringExtra("add");
        EditText editedAddress = findViewById(R.id.sde_value_add);
        Boolean check = intent.getBooleanExtra("check", false);
        CheckBox editedCheck = findViewById(R.id.checkBox);

        // Import old student
        Student oldStudent = new Student(name, id, address, phone, check);

        // Import new intent
        intentDetailsWithExtra = new Intent(this, StudentDetails.class);

        // Click on cancel
        Button cancelButton = findViewById(R.id.sd_edit_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIntentCurrentDetails(editedName.getText().toString(), editedId.getText().toString(),
                        editedAddress.getText().toString(), editedPhone.getText().toString(), editedCheck.isChecked());
                startActivity(intentDetailsWithExtra);
            }
        });

        // Click on save
        Button saveButton = findViewById(R.id.sd_edit_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student newStudent = new Student(editedName.getText().toString(), editedId.getText().toString(),
                        editedAddress.getText().toString(), editedPhone.getText().toString(), editedCheck.getFreezesText());
                Model.instance.updateStudent(oldStudent, newStudent);

                addIntentCurrentDetails(editedName.getText().toString(), editedId.getText().toString(),
                        editedAddress.getText().toString(), editedPhone.getText().toString(), editedCheck.isChecked());
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

    private void addIntentCurrentDetails(String name, String id, String address, String phone, boolean checked) {
        intentDetailsWithExtra.putExtra("name", name);
        intentDetailsWithExtra.putExtra("id", id);
        intentDetailsWithExtra.putExtra("add", address);
        intentDetailsWithExtra.putExtra("phone", phone);
        intentDetailsWithExtra.putExtra("check", checked);
    }

    /**
     * This function get an id, extra and intent the set the data from a text view
     *
     * @param intent
     * @param extra
     * @param id
     */
    private void setTextViewWithPreviousItem(Intent intent, String extra, int id) {
        String stringExtra = intent.getStringExtra(extra);
        TextView textView = findViewById(id);
        textView.setText(stringExtra);
    }

    /**
     * This function get the intent and extra and id and set the data with the previous details
     *
     * @param intent
     * @param extra
     * @param id
     */
    private void setCheckBoxWithPreviousItem(Intent intent, String extra, int id) {
        Boolean check = intent.getBooleanExtra(extra, false);
        CheckBox editedCheck = findViewById(id);
        editedCheck.setChecked(check);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}