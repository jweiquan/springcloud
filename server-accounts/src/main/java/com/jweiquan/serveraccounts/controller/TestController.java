package com.jweiquan.serveraccounts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("hello")
    public String getHello() {
        return "Hello accounts!";
    }
}
