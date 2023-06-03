package miu.edu.mocktest.Repo;

import miu.edu.mocktest.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long>  {
    List<Course> findAll();
    Course findById(long id);
}
