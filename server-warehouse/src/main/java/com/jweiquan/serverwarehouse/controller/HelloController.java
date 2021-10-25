package com.jweiquan.serverwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@ResponseBody
public class HelloController {
    @Autowired
    private ServiceAccountsFeignClient serviceAccountsFeignClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloFromAccountsService() {
        return this.serviceAccountsFeignClient.getHello();
    }
}
