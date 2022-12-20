package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("New Student");

            nameEt = findViewById(R.id.name_input);
            idEt = findViewById(R.id.id_input);
            phoneEt = findViewById(R.id.phone_input);
            addressEt = findViewById(R.id.address_input);
            cb = findViewById(R.id.student_cb);

            Button cancelBtn = findViewById(R.id.cancel_btn);
            Button saveBtn = findViewById(R.id.save_btn);

            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student editedStudent = new Student(nameEt.getText().toString(),idEt.getText().toString(), phoneEt.getText().toString(), addressEt.getText().toString(),cb.isChecked());
                    Model.instance.addStudent(editedStudent);
                    Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });



    }
}