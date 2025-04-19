package com.library.devpulse.controller;


import com.library.devpulse.annotation.Profiled;
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
}
