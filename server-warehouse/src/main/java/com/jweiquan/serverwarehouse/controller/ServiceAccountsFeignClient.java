package com.jweiquan.serverwarehouse.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVER-ACCOUNTS")
public interface ServiceAccountsFeignClient {
    @RequestMapping("hello")
    public String getHello();
}
