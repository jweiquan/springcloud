package com.jweiquan.serverwarehouse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BrandUserService {
    public HashMap<Integer, RuleService.RuleSnapshot.Client> getClientMapByBrandUserIds(Integer[] brandUserIds) {
        HashMap<Integer, RuleService.RuleSnapshot.Client> map = new HashMap<>();
        return map;
    }
}
