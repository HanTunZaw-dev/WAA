package miu.edu.lab.repo;

import miu.edu.lab.domain.Logger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoggerRepo extends CrudRepository<Logger, Long> {
    public List<Logger> findAll();
}
