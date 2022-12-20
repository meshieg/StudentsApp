package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class ViewStudentActivity extends AppCompatActivity {
    List<Student> data;
    TextView nameTt;
    TextView idTt;
    TextView phoneTt;
    TextView addressTt;
    CheckBox cb;
    Student student;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Student Details");

        data = Model.instance.getAllStudents();

        Bundle b = getIntent().getExtras();
        position = b.getInt("id");


        student = data.get(position);

        nameTt = findViewById(R.id.student_name);
        idTt = findViewById(R.id.student_id);
        phoneTt = findViewById(R.id.student_phone);
        addressTt = findViewById(R.id.student_address);
        cb = findViewById(R.id.student_cb);

        nameTt.setText(student.getName());
        idTt.setText(student.getId());
        phoneTt.setText(student.getPhone());
        addressTt.setText(student.getAddress());
        cb.setChecked(student.getIsChecked());

        Button editBtn = findViewById(R.id.edit_btn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewStudentActivity.this, EditStudentActivity.class);
                Bundle b = new Bundle();
                b.putInt("id", position); //Your id
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });

    }
}