package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlatformService {
    public HashMap<Integer, RuleService.RuleSnapshot.Platform> getPlatformMapByIds(Integer[] platformIds, User user) {
        HashMap<Integer, RuleService.RuleSnapshot.Platform> map = new HashMap<>();
        return map;
    }
}
