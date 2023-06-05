package miu.edu.lab.service;

import miu.edu.lab.domain.Logger;
import miu.edu.lab.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class LoggerServiceImpl implements LoggerService{
    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public List<Logger> findAll() {
        return loggerRepo.findAll();
    }

    @Override
    public void save(Logger l) {
        loggerRepo.save(l);
        System.out.println("=============================================");
        System.out.println("**** Logger Service Saved ****");
        System.out.println("=============================================");
    }
}
