package com.library.devpulse.sessionFactory;


import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        return emf.unwrap(SessionFactory.class);
    }
}
