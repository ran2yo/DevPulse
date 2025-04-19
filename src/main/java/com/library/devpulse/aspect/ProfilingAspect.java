package com.library.devpulse.aspect;



import com.library.devpulse.logging.DevLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Map;
import java.util.Set;

//loging을 위한 Lombok 애노테이션
@Slf4j
//AOP로 동작하는 클래스임을 선언
@Aspect
@Component //Spring 빈으로 등록
public class ProfilingAspect {

    private final SessionFactory sessionFactory;

    public ProfilingAspect(@Lazy SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Profiled 어노테이션이 붙은 메서드 주변에서 실행되는 로직
    @Around("@annotation(com.library.devpulse.annotation.Profiled)")
    public Object profileMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // start time profiled

        Object result = joinPoint.proceed();  // endpoint method start
        long end = System.currentTimeMillis(); //stop time profiled
        long duration = end - start;

        log.info("[Profiled] {} 실행 시간: {} ms",
                joinPoint.getSignature().toShortString(), (end - start));  // 실행 시간 로그 출력

        //Hibernate Statistics 수집

        SessionFactoryImplementor sfi = (SessionFactoryImplementor) sessionFactory;
        Statistics stats = sfi.getStatistics();

        for (String query : stats.getQueries()) {
            QueryStatistics q = stats.getQueryStatistics(query);
            //실행된 쿼리만 필터링
            if(q.getExecutionCount() == 0) continue;

            long avg = q.getExecutionAvgTime();
            long max = q.getExecutionMaxTime();
            long total = q.getExecutionTotalTime();
            DevLog.tag((Class<?>) getClass(), "DB").info(
                    "쿼리 [{}]\n→ 실행 {}회, 평균 {}ms, 최대 {}ms, 총 {}ms",
                    query, q.getExecutionCount(), avg, max, total
            );
        }


        return result;
    }

}
