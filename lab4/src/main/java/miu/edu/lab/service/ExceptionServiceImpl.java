package miu.edu.lab.service;

import miu.edu.lab.repo.ExceptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ExceptionServiceImpl implements ExceptionService{
    @Autowired
    ExceptionRepo exceptionRepo;

    @Override
    public List<miu.edu.lab.domain.Exception> findAll() {
        return exceptionRepo.findAll();
    }

    @Override
    public void save(miu.edu.lab.domain.Exception e) {
        exceptionRepo.save(e);
        System.out.println("=============================================");
        System.out.println("**** Exception Service Saved ****");
        System.out.println("=============================================");
    }
}
