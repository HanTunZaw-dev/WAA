package miu.edu.lab.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDateTime date;
    private String principle;
    private String operation;
    private String exceptionType;

    public Exception(LocalDateTime date, String principle, String operation, String exceptionType) {

        this.date = date;
        this.principle = principle;
        this.operation = operation;
        this.exceptionType = exceptionType;
    }
}
