package miu.edu.mocktest.service;

import miu.edu.mocktest.domain.Course;

import java.util.List;

public interface CourseService{
    List<Course> findAll();
    public Course getById(long id);
    public void addCourse(Course p);
    public void deleteCourse(long id);
    public void updateCourse(long id, Course p);
}
