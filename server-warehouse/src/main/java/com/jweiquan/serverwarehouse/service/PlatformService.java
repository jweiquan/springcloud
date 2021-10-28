package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class PlatformService {
    public HashMap<Integer, RuleSnapshot.Platform> getPlatformMapByIds(Set<Integer> platformIds, User user) {
        HashMap<Integer, RuleSnapshot.Platform> map = new HashMap<>();
        return map;
    }
}
