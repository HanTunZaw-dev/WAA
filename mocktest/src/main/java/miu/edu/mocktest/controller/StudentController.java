package miu.edu.mocktest.controller;

import miu.edu.mocktest.domain.Student;
import miu.edu.mocktest.dto.StudentDto;
import miu.edu.mocktest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDto> getPostUser(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto getPostUserById(@PathVariable("id") long id) {
        return  studentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody Student student){
        studentService.addStudent(student);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody Student student){
        studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        studentService.deleteStudent(id);
    }
}
