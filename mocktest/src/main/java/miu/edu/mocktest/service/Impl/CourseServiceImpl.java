package miu.edu.mocktest.service.Impl;

import miu.edu.mocktest.Repo.CourseRepo;
import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(long id) {
        return modelMapper.map(courseRepo.findById(id), Course.class);
    }

    @Override
    public void addCourse(Course c) {
        courseRepo.save(c);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void updateCourse(long id, Course c) {
        if(courseRepo.existsById(id)) {
            courseRepo.save(c);
        }
    }
}
