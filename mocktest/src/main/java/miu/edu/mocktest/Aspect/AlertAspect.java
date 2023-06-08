package miu.edu.mocktest.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlertAspect {

    @Pointcut("execution(java.util.List<miu.edu.mocktest.domain.Student> miu.edu.mocktest.controller.StudentController.*(..))")
    private void returnListStudentController(){}

    @AfterReturning("returnListStudentController()")
    public void sendAlert( JoinPoint joinpoint ){
        // implementation to send alert ...
        System.out.println(joinpoint);
    }
}
