package com.example.studentsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Students List");

        data = Model.instance.getAllStudents();

        FloatingActionButton addStudent = findViewById(R.id.addStudent);
        RecyclerView list = findViewById(R.id.student_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, ViewStudentActivity.class);
                Bundle b = new Bundle();
                b.putInt("id", position);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.listrow_name);
            idTv = itemView.findViewById(R.id.listrow_id);
            cb = itemView.findViewById(R.id.listrow_is_checked);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Student cbEditedStudent = Model.instance.getAllStudents().get(pos);
                    cbEditedStudent.setIsChecked(cb.isChecked());
                    Model.instance.editStudent(pos,cbEditedStudent);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            MyViewHolder holder = new MyViewHolder(view,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.nameTv.setText(student.getName());
            holder.idTv.setText(student.getId());
            holder.cb.setChecked(student.getIsChecked());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}