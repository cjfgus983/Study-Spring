package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* hello.hello_spring..*(..))") // 중간에 인터셉팅 해서 뭔가를 하는거
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        System.out.println("Start Time : " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        } finally {
            Long endTime = System.currentTimeMillis();
            long timeMs = endTime - startTime;
            System.out.println("END: " +joinPoint.toString() +" " + timeMs + " ms");
        }
    }
}