package com.library.devpulse.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//loging을 위한 Lombok 애노테이션
@Slf4j
//AOP로 동작하는 클래스임을 선언
@Aspect
@Component //Spring 빈으로 등록
public class ProfilingAspect {

    //Profiled 어노테이션이 붙은 메서드 주변에서 실행되는 로직
    @Around("@annotation(com.library.devpulse.annotation.Profiled)")
    public Object profileMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // start time profiled

        Object result = joinPoint.proceed();  // endpoint method start
        long end = System.currentTimeMillis(); //stop time profiled



        log.info("[Profiled] {} 실행 시간: {} ms",
                joinPoint.getSignature().toShortString(), (end - start));  // 실행 시간 로그 출력

        return result;
    }

}
