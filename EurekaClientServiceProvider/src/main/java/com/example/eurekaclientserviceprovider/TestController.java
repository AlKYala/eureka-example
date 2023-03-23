package com.example.eurekaclientserviceprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/check")
    public String getCheckMessage() {
        return "Connection to Service Provider successful";
    }
}
