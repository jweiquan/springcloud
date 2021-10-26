package com.jweiquan.serverwarehouse.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Entity
@Table(name = "job")
@TypeDef(name = "json", typeClass = JsonType.class)
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

    @Type(type = "json")
    @Column(name = "rule_snapshot", columnDefinition = "json")
    private Object ruleSnapshot;

    @Column(name = "status")
    private Byte status;

    @Column(name = "is_job_label_printed")
    private Byte isJobLabelPrinted;

    @Column(name = "is_picked")
    private Byte isPicked;

    @Column(name = "is_shipment_label_printed")
    private Byte isShipmentLabelPrinted;

    @Column(name = "is_packed")
    private Byte isPacked;

    @Column(name = "is_shipped")
    private Byte isShipped;

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
