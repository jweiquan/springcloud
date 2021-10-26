package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StoreService {
    public HashMap<Integer, RuleSnapshot.Store> getStoreMapByIds(Integer[] ids, User user) {
        HashMap<Integer, RuleSnapshot.Store> map = new HashMap<>();
        return map;
    }
}
