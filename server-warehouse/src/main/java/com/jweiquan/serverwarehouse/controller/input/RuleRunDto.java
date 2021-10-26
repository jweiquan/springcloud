package com.jweiquan.serverwarehouse.controller.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RuleRunDto {
    @NotNull
    private Integer[] ruleIds;
}
