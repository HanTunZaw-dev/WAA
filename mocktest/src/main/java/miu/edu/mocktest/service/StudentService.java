package miu.edu.mocktest.service;

import miu.edu.mocktest.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    public Student getById(long id);
    public void addStudent(Student p);
    public void deleteStudent(long id);
    public void updateStudent(long id, Student p);
}
