package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.ApiException;
import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.Rule;
import com.jweiquan.serverwarehouse.repository.RuleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RuleService {
    @Getter
    @Setter
    public static class RuleSnapshot {
        private Integer id;
        private String name;
        private Integer jobPriority;
        private Client[] clients;
        private Warehouse warehouse;
        private Byte isMultiple;
        private String[] carriers;
        private String[] serviceCodes;
        private Service[] services;
        private String[] accounts;
        private Platform[] platforms;
        private Store[] stores;
        private String[] shipBy;
        private String[] sku;
        private Integer maxOrderQty;
        private Integer maxProductQty;
        private Integer maxProductCategory;
        private Country countries;
        private String[] orderCreatedAt;
        private String[] optionalConditions;


        @Getter
        @Setter
        public static class Client {
            private Integer brandUserId;
            private String name;
        }

        @Getter
        @Setter
        public static class Warehouse {
            private Integer id;
            private String name;
        }

        @Getter
        @Setter
        public static class Service {
            private String carrier;
            private String service_code;
            private String service_name;
        }

        @Getter
        @Setter
        public static class Platform {
            private Integer id;
            private String name;
            private String iconPath;
            private String logoPath;
            private Boolean isStore;
            private Boolean isWms;
        }

        @Getter
        @Setter
        public static class Store {
            private Integer id;
            private String name;
            private Boolean authenticationStatus;
            private Platform platform;
        }

        @Getter
        @Setter
        public static class Country {
            private String code;
            private String name;
        }
    }

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 创建快照
     */
    public RuleSnapshot createRuleSnapshot(Rule rule, User user) {
        RuleSnapshot ruleSnapshot = new RuleSnapshot();

        if (rule.getWarehouseId() != null) {
            ruleSnapshot.setWarehouse(this.warehouseService.getWarehouseByWarehouseId(rule.getWarehouseId(), user));
        }

        return null;
    }

    /**
     * 执行规则
     * @param ruleIds Integer[]
     * @param user User
     * @return success Boolean
     */
    public Boolean runRuleByIds(Integer[] ruleIds, User user) {
        Byte isActive = 1;
        List<Rule> rules = this.ruleRepository.findAllByIdInAndBrandUserIdAndActive(ruleIds, user.getBrandUserId(), isActive);
        if (rules.isEmpty()) {
            throw new ApiException(100, "Rules not found!");
        }


        // TODO
        return true;
    }
}
