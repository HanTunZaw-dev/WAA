package miu.edu.mocktest.Repo;

import miu.edu.mocktest.domain.Course;
import miu.edu.mocktest.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.gpa <= :num")
    public List<Student> getStudentsByLessThanEqualGPA(float num);

    @Query("select s from Student s join s.course c where c.course_details.program = :program")
    public List<Student> getStudentsByProgram(String program);

    public List<Student> getStudentsByNameEquals(String student);
}
