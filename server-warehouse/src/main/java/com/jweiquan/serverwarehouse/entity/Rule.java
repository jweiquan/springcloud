package com.jweiquan.serverwarehouse.entity;

import com.jweiquan.serverwarehouse.common.BaseSaasEntity;
import lombok.Getter;
import lombok.Setter;
import reactor.util.function.Tuple2;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Date;

@Getter
@Setter
@Table(name = "rule")
public class Rule extends BaseSaasEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_multiple", nullable = false)
    private Integer isMultiple;

    @Column(name = "warehouse_id", nullable = false)
    private Integer warehouseId;

    @Transient
    @Column(name = "client_ids")
    private Integer[] clientIds;

    @Transient
    @Column(name = "store_ids")
    private Integer[] storeIds;

    @Transient
    @Column(name = "carriers")
    private String[] carriers;

    @Transient
    @Column(name = "service_codes")
    private String[] serviceCodes;

    @Transient
    @Column(name = "accounts")
    private String[] accounts;

    @Transient
    @Column(name = "ship_to_country_codes")
    private String[] shipToCountryCodes;

    @Column(name = "max_product_qty")
    private Integer maxProductQty;

    @Column(name = "max_product_category")
    private Integer maxProductCategory;

    @Transient
    @Column(name = "sku")
    private String[] sku;

    @Transient
    @Column(name = "ship_by_range")
    private Tuple2<Date, Date> shipByRange;

    @Transient
    @Column(name = "order_created_at")
    private Tuple2<Date, Date> orderCreatedAt;

    @Transient
    @Column(name = "platform_ids")
    private Integer[] platformIds;

    @Column(name = "max_order_qty")
    private Integer maxOrderQty;

    @Transient
    @Column(name = "optional_conditions")
    private String[] optionalConditions;

    @Column(name = "job_priority")
    private Integer jobPriority;

    @Column(name = "active")
    private Integer active;

    @Column(name = "brand_id")
    private Integer brandId;
}
