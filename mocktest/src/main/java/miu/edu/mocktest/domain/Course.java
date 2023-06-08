package miu.edu.mocktest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Data
@Entity
public class Course {
    @Id
    long id;
    String name;

    @ManyToMany(mappedBy = "course")
    @BatchSize(size = 10)
    List<Student> student;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    Course_Details course_details;
}
