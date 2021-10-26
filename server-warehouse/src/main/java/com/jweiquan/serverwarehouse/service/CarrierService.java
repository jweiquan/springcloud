package com.jweiquan.serverwarehouse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CarrierService {
    public HashMap<String, RuleService.RuleSnapshot.Service> getServiceMapByServiceCodes(String[] codes, String accountAlias) {
        HashMap<String, RuleService.RuleSnapshot.Service> map = new HashMap<>();
        return map;
    }

    public HashMap<String, RuleService.RuleSnapshot.Country> getCountryMapByCodes(String[] codes) {
        HashMap<String, RuleService.RuleSnapshot.Country> map = new HashMap<>();
        return map;
    }
}
