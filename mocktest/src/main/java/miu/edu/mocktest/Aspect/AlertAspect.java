package miu.edu.mocktest.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AlertAspect {

    @Pointcut("execution(public List<Student> miu.edu.mocketest.controller.*(..))")
    private void returnListStudentController(){}

    @AfterReturning(pointcut = "returnListStudentController()")
    public void sendAlert( JoinPoint joinpoint ){
        // implementation to send alert ...
    }
}
