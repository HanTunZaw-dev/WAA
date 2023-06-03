package miu.edu.mocktest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    private long id;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @OneToOne( mappedBy = "courses")
    private Course_Details course_details;
}
