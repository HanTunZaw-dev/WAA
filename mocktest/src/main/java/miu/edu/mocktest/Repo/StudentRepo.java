package miu.edu.mocktest.Repo;

import miu.edu.mocktest.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Student findById(long id);
}
