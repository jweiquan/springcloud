package com.jweiquan.serverwarehouse.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleSnapshot {
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
    private Country[] countries;
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
