package miu.edu.mocktest.service.Impl;

import miu.edu.mocktest.Repo.StudentRepo;
import miu.edu.mocktest.domain.Student;
import miu.edu.mocktest.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(long id) {
        return modelMapper.map(studentRepo.findById(id), Student.class);
    }

    @Override
    public void addStudent(Student s) {
        studentRepo.save(s);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void updateStudent(long id, Student s) {
        if(studentRepo.existsById(id)) {
            studentRepo.save(s);
        }
    }
}
