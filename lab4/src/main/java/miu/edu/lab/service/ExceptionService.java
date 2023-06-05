package miu.edu.lab.service;

import java.util.List;

public interface ExceptionService {
    public List<miu.edu.lab.domain.Exception> findAll();
    public void save(miu.edu.lab.domain.Exception e);
}
