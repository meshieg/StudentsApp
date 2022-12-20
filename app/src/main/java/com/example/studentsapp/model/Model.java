package com.example.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();
    private List<Student> studentList = new LinkedList<Student>();

    private Model(){
        Student s1 = new Student("Meshi","111111", "054444466", "rishon",false);
        studentList.add(s1);

        Student s2 = new Student("Ofir","222222", "052666666", "holon",true);
        studentList.add(s2);

        Student s3 = new Student("Menachem","333333", "97345506666", "rishon",false);
        studentList.add(s3);

        Student s4 = new Student("Yossi","444444", "0506666", "bat yam",false);
        studentList.add(s4);

        Student s5 = new Student("Sason","555555", "0555556666", "tel-aviv",true);
        studentList.add(s5);

        Student s6 = new Student("Dani","666666", "0506666", "rishon",false);
        studentList.add(s6);
    }

    public List<Student> getAllStudents(){
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void deleteStudent(Student student) {
        studentList.remove(student);
    }

    public void editStudent(int position, Student student) {
        studentList.set(position,student);
    }
}