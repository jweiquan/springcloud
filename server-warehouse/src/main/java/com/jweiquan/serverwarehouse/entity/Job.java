package com.jweiquan.serverwarehouse.entity;

import com.jweiquan.serverwarehouse.common.BaseSaasEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "job")
public class Job extends BaseSaasEntity {
    @Column(name = "job_no")
    private String jobNo;

    @Column(name = "rule_id")
    private Integer ruleId;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "rule_snapshot")
    private Object ruleSnapshot;

    @Column(name = "status")
    private Integer status;

    @Column(name = "is_job_label_printed")
    private Integer isJobLabelPrinted;

    @Column(name = "is_picked")
    private Integer isPicked;

    @Column(name = "is_shipment_label_printed")
    private Integer isShipmentLabelPrinted;

    @Column(name = "is_packed")
    private Integer isPacked;

    @Column(name = "is_shipped")
    private Integer isShipped;
}
