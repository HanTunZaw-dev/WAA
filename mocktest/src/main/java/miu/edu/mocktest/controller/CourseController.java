package miu.edu.mocktest.controller;

import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.dto.CourseDto;
import miu.edu.mocktest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public List<CourseDto> getPostUser(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDto getPostUserById(@PathVariable("id") long id) {
        return courseService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody Course course){
        courseService.addCourse(course);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody Course course){
        courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        courseService.deleteCourse(id);
    }
}
