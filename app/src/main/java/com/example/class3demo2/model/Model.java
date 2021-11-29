package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model() {
        for (int i = 0; i < 20; i++) {
            Student s = new Student("name " + i, "" + i, "rishon lezion", "053", false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public Student findTheStudent(String name, String id) {
        Student StudentToCheck = new Student(name, id, "", "", false);
        for (int i = 0; i < data.size(); i++) {
            if (checkIfTheStudentEquals(StudentToCheck, data.get(i))) {
                return data.get(i);
            }
        }
        return new Student("", "", "", "", false);
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public boolean checkIfTheStudentEquals(Student student1, Student student2) {
        if (student1.getId().equals(student2.getId()) &&
                student1.getName().equals(student2.getName())) {
            return true;
        }
        return false;
    }

    public void updateStudent(Student oldStudent, Student newStudent) {
        for (int i = 0; i < data.size(); i++) {
            if (checkIfTheStudentEquals(oldStudent, data.get(i))) {
                data.get(i).setAddress(newStudent.getAddress());
                data.get(i).setId(newStudent.getId());
                data.get(i).setPhone(newStudent.getPhone());
                data.get(i).setName(newStudent.getName());
                data.get(i).setFlag(newStudent.isFlag());
                return;
            }
        }
    }

    public void deleteStudent(Student oldStudent) {
        for (int i = 0; i < data.size(); i++) {
            if (checkIfTheStudentEquals(oldStudent, data.get(i))) {
                data.remove(i);
                return;
            }
        }
    }
}
