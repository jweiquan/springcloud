package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CarrierService {
    public HashMap<String, RuleSnapshot.Service> getServiceMapByServiceCodes(String[] codes, String accountAlias) {
        HashMap<String, RuleSnapshot.Service> map = new HashMap<>();
        return map;
    }

    public HashMap<String, RuleSnapshot.Country> getCountryMapByCodes(String[] codes) {
        HashMap<String, RuleSnapshot.Country> map = new HashMap<>();
        return map;
    }
}
