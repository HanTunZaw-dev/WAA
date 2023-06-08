package miu.edu.mocktest.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlertAspect {

    @Pointcut("execution(java.util.List<miu.edu.mocketest.domain.Student> miu.edu.mocketest.controller.StudentController.*(..))")
    private void returnListStudentController(){}

    @AfterReturning("returnListStudentController()")
    public void sendAlert( JoinPoint joinpoint ){
        // implementation to send alert ...
    }
}
