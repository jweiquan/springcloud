package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class StoreService {
    public HashMap<Integer, RuleSnapshot.Store> getStoreMapByIds(Set<Integer> ids, User user) {
        HashMap<Integer, RuleSnapshot.Store> map = new HashMap<>();
        return map;
    }
}
