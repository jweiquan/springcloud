package com.jweiquan.serverwarehouse.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_no")
    private String jobNo;

    @Column(name = "rule_id")
    private Integer ruleId;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

//    @Column(name = "rule_snapshot")
//    private Object ruleSnapshot;

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
