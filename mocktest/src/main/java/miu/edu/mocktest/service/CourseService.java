package miu.edu.mocktest.service;

import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.dto.CourseDto;

import java.util.List;

public interface CourseService{
    List<CourseDto> findAll();
    public CourseDto getById(long id);
    public void addCourse(Course p);
    public void deleteCourse(long id);
    public void updateCourse(long id, Course p);
}
