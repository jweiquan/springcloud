package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class BrandUserService {
    public HashMap<Integer, RuleSnapshot.Client> getClientMapByBrandUserIds(Set<Integer> brandUserIds) {
        HashMap<Integer, RuleSnapshot.Client> map = new HashMap<>();
        return map;
    }
}
