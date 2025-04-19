package com.library.devpulse.controller;


import com.library.devpulse.annotation.Profiled;
import com.library.devpulse.logging.DevLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/hello")
    @Profiled("helloMethod")
    public String hello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello DevPulse!";
    }

    @GetMapping("/log-test")
    public String logTest() {
        DevLog.tag(ExampleController.class, "TEST").info("테스트 로그입니다!");
        return "로그 테스트 완료";
    }
}

