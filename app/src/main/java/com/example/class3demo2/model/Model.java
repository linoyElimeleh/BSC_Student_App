package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model() {
        for (int i = 0; i < 10; i++) {
            Student s = new Student("name " + i, "" + i, false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public boolean checkIfTheStudentEquals(Student student1, Student student2) {
        if (student1.getId() == student2.getId() &&
                student1.getName() == student2.getName() &&
                student1.getPhone() == student2.getPhone() &&
                student1.getAddress() == student2.getAddress()) {
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
