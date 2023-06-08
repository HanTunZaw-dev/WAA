package miu.edu.mocktest.controller;

import miu.edu.mocktest.Repo.StudentRepo;
import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.domain.Student;
import miu.edu.mocktest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {

    @Autowired
    StudentService studentService;

    private final StudentRepo studentRepo;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Student student){
        studentRepo.save(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Student> findAll(
            @RequestParam(value = "filter", required = false) String criteria,
            @RequestParam(value = "student", required = false) String student
    ){
        if(criteria != null && criteria.equals("course-name")) return studentRepo.getStudentsByNameEquals(student);
        return studentRepo.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Student getById(@PathVariable long id){
        return studentRepo.getById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void update(
            @PathVariable long id,
            @RequestBody Student student
    ){
        studentService.updateStudent(id, student);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable long id
    ){
        studentRepo.deleteById(id);
    }

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/courses")
    public List<Course> getCourseByStudentId(@PathVariable("id") long studentId){
        return studentRepo.findById(studentId).get().getCourse();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/gpa/{num}")
    public List<Student> getStudentsByLessThanEqualGPA(@PathVariable("num") float num){
        return studentRepo.getStudentsByLessThanEqualGPA(num);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/courses/programs/{program}")
    public List<Student> getStudentsByProgram(@PathVariable("program") String program){
        return studentRepo.getStudentsByProgram(program);
    }
}
