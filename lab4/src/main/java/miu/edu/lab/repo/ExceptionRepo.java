package miu.edu.lab.repo;

import miu.edu.lab.domain.Exception;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExceptionRepo extends CrudRepository<Exception, Long> {

    public List<Exception> findAll();

}
