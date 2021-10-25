package com.jweiquan.serverwarehouse.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class BaseSaasEntity extends BaseEntity {
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "brand_user_id")
    private Integer brandUserId;
}
