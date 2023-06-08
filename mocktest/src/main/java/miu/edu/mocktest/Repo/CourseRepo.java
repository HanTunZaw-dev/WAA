package miu.edu.mocktest.Repo;

import miu.edu.mocktest.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    public List<Course> getCoursesByNameEquals(String course);
}
