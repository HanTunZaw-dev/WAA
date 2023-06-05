package miu.edu.lab.service;

import miu.edu.lab.domain.Logger;

import java.util.List;

public interface LoggerService {
    public List<Logger> findAll();
    public void save(Logger l);
}
