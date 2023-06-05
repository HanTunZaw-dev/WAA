package miu.edu.lab.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDateTime date;
    private String principle;
    private String operation;


    public Logger(LocalDateTime date, String principle, String operation) {

        this.date = date;
        this.principle = principle;
        this.operation = operation;
    }
}
