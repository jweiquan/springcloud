package com.jweiquan.serverwarehouse.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity(name = "rule")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Rule {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_multiple", nullable = false)
    private Integer isMultiple;

    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;

    @Type(type = "json")
    @Column(name = "client_ids", columnDefinition = "json")
    private Integer[] clientIds;

    @Type(type = "json")
    @Column(name = "store_ids", columnDefinition = "json")
    private Integer[] storeIds;

    @Type(type = "json")
    @Column(name = "carriers", columnDefinition = "json")
    private String[] carriers;

    @Type(type = "json")
    @Column(name = "service_codes", columnDefinition = "json")
    private String[] serviceCodes;

    @Type(type = "json")
    @Column(name = "accounts", columnDefinition = "json")
    private String[] accounts;

    @Type(type = "json")
    @Column(name = "ship_to_country_codes", columnDefinition = "json")
    private String[] shipToCountryCodes;

    @Column(name = "max_product_qty")
    private Integer maxProductQty;

    @Column(name = "max_product_category")
    private Integer maxProductCategory;

    @Type(type = "json")
    @Column(name = "sku", columnDefinition = "json")
    private String[] sku;

    @Type(type = "json")
    @Column(name = "ship_by_range", columnDefinition = "json")
    private String[] shipByRange;

    @Type(type = "json")
    @Column(name = "order_created_at", columnDefinition = "json")
    private String[] orderCreatedAt;

    @Type(type = "json")
    @Column(name = "platform_ids", columnDefinition = "json")
    private Integer[] platformIds;

    @Column(name = "max_order_qty")
    private Integer maxOrderQty;

    @Type(type = "json")
    @Column(name = "optional_conditions", columnDefinition = "json")
    private String[] optionalConditions;

    @Column(name = "job_priority")
    private Integer jobPriority;

    @Column(name = "active")
    private Byte active;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "brand_user_id")
    private Integer brandUserId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
