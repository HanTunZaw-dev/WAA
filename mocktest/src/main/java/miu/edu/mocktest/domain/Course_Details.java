package miu.edu.mocktest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_details")
public class Course_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long description_id;
    private String course_description;
    private float credit;
    private String program;
    private int last_updated;
    @OneToOne
    private Course courses;
}
