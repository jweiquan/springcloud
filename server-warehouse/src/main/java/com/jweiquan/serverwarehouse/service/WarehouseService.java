package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WarehouseService {
    public HashMap<Integer, RuleSnapshot.Warehouse> getWarehouseIdWarehouseMap(Integer[] id, User user) {
        HashMap<Integer, RuleSnapshot.Warehouse> map = new HashMap<>();

        // TODO

        return map;
    }

    public RuleSnapshot.Warehouse getWarehouseByWarehouseId(Integer id, User user) {
        RuleSnapshot.Warehouse warehouse = new RuleSnapshot.Warehouse();
        return warehouse;
    }
}
