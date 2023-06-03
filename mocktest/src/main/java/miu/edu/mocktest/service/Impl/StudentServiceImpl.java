package miu.edu.mocktest.service.Impl;

import miu.edu.mocktest.Repo.StudentRepo;
import miu.edu.mocktest.domain.Student;
import miu.edu.mocktest.dto.StudentDto;
import miu.edu.mocktest.helper.ListMapper;
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

    @Autowired
    ListMapper<Student, StudentDto> listMapperStudentToDto;
    @Override
    public List<StudentDto> findAll() {
        return (List<StudentDto>) listMapperStudentToDto.mapList(studentRepo.findAll(), new StudentDto());
    }

    @Override
    public StudentDto getById(long id) {
        return modelMapper.map(studentRepo.findById(id), StudentDto.class);
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
