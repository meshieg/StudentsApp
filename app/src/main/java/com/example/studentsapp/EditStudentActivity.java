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

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {

    List<Student> data;
    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox cb;
    Student student;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Student Edit");

        data = Model.instance.getAllStudents();

        Bundle b = getIntent().getExtras();
        position = b.getInt("id");


        student = data.get(position);

        nameEt = findViewById(R.id.name_input);
        idEt = findViewById(R.id.id_input);
        phoneEt = findViewById(R.id.phone_input);
        addressEt = findViewById(R.id.address_input);
        cb = findViewById(R.id.student_cb);

        nameEt.setText(student.getName());
        idEt.setText(student.getId());
        phoneEt.setText(student.getPhone());
        addressEt.setText(student.getAddress());
        cb.setChecked(student.getIsChecked());

        Button cancelBtn = findViewById(R.id.cancel_btn);
        Button deleteBtn = findViewById(R.id.delete_btn);
        Button saveBtn = findViewById(R.id.save_btn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditStudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.instance.deleteStudent(student);
                Intent intent = new Intent(EditStudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student editedStudent = new Student(nameEt.getText().toString(),idEt.getText().toString(), phoneEt.getText().toString(), addressEt.getText().toString(),cb.isChecked());
                Model.instance.editStudent(position, editedStudent);
                Intent intent = new Intent(EditStudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}