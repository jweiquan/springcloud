package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class CarrierService {
    public HashMap<String, RuleSnapshot.Service> getServiceMapByServiceCodes(Set<String> codes) {
        HashMap<String, RuleSnapshot.Service> map = new HashMap<>();
        return map;
    }

    public HashMap<String, RuleSnapshot.Country> getCountryMapByCodes(Set<String> codes) {
        HashMap<String, RuleSnapshot.Country> map = new HashMap<>();
        return map;
    }
}
