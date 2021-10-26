package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StoreService {
    public HashMap<Integer, RuleService.RuleSnapshot.Store> getStoreMapByIds(Integer[] ids, User user) {
        HashMap<Integer, RuleService.RuleSnapshot.Store> map = new HashMap<>();
        return map;
    }
}
