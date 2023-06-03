package miu.edu.mocktest.service;

import miu.edu.mocktest.domain.Student;
import miu.edu.mocktest.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    public StudentDto getById(long id);
    public void addStudent(Student p);
    public void deleteStudent(long id);
    public void updateStudent(long id, Student p);
}
