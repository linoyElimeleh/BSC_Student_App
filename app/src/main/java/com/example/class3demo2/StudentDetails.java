package com.example.class3demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;


public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_view);

        // Get the intent from the previous page
        Intent oldIntent = getIntent();

        // Get previous data
        setTextViewWithPreviousItem(oldIntent, "name", R.id.sd_value_name);
        setTextViewWithPreviousItem(oldIntent, "id", R.id.sd_value_id);
        setTextViewWithPreviousItem(oldIntent, "phone", R.id.sd_value_phone);
        setTextViewWithPreviousItem(oldIntent, "add", R.id.sd_value_add);
        setCheckBoxWithPreviousItem(oldIntent, "check", R.id.sd_checkBox);

        // Set the intent page
        oldIntent.setClass(this, StudentEdit.class);

        // On edit action
        Button editButton = findViewById(R.id.sd_edit_btn);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(oldIntent);
            }
        });
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
}