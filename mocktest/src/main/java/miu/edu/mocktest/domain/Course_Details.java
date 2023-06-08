package miu.edu.mocktest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String course_description;
    float credit;
    String program;
    int last_updated;

    @OneToOne
    Course course;

}
