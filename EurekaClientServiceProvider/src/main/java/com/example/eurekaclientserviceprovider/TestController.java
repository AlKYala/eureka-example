package com.example.eurekaclientserviceprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/check")
    public String getCheckMessage() {
        return "Connection to Service Provider successful";
    }
}
