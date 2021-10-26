package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BrandUserService {
    public HashMap<Integer, RuleSnapshot.Client> getClientMapByBrandUserIds(Integer[] brandUserIds) {
        HashMap<Integer, RuleSnapshot.Client> map = new HashMap<>();
        return map;
    }
}
