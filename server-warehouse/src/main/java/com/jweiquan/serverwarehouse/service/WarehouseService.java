package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WarehouseService {
    public HashMap<Integer, RuleService.RuleSnapshot.Warehouse> getWarehouseIdWarehouseMap(Integer[] id, User user) {
        HashMap<Integer, RuleService.RuleSnapshot.Warehouse> map = new HashMap<>();

        // TODO

        return map;
    }

    public RuleService.RuleSnapshot.Warehouse getWarehouseByWarehouseId(Integer id, User user) {
        RuleService.RuleSnapshot.Warehouse warehouse = new RuleService.RuleSnapshot.Warehouse();
        return warehouse;
    }
}
