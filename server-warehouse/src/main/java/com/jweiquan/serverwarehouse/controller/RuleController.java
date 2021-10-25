package com.jweiquan.serverwarehouse.controller;

import com.jweiquan.serverwarehouse.entity.Rule;
import com.jweiquan.serverwarehouse.mapper.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    RuleMapper ruleMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Rule> getList() {
        return this.ruleMapper.selectAll();
    }
}
