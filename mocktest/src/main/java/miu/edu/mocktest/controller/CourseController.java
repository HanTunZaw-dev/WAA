package miu.edu.mocktest.controller;

import miu.edu.mocktest.Repo.CourseRepo;
import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    CourseService courseService;
    private final CourseRepo courseRepo;

    public CourseController(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Course course){
        courseRepo.save(course);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Course> findAll(
            @RequestParam(value = "filter", required = false) String criteria,
            @RequestParam(value = "course", required = false) String course
    ){
        if(criteria != null && criteria.equals("course-name")) return courseRepo.getCoursesByNameEquals(course);
        return courseRepo.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Course getById(@PathVariable long id){
        return courseRepo.getById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void update(
            @PathVariable long id,
            @RequestBody Course course
    ){
        courseService.updateCourse(id, course);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable long id
    ){
        courseRepo.deleteById(id);
    }
}
