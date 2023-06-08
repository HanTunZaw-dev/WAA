package miu.edu.mocktest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String city;
    String state;
    int zipcode;

    @OneToMany
    @JoinColumn(name = "address_id")
    @BatchSize(size = 10)
    List<Student> student;
}
