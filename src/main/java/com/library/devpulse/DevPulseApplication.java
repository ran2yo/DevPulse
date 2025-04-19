package com.library.devpulse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.library.devpulse.repository")
@EntityScan(basePackages = "com.library.devpulse.domain")
public class DevPulseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevPulseApplication.class, args);
    }


}


