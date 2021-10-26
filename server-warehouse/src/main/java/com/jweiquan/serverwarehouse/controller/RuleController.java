package com.jweiquan.serverwarehouse.controller;

import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.controller.input.RuleRunDto;
import com.jweiquan.serverwarehouse.entity.Rule;
import com.jweiquan.serverwarehouse.repository.RuleRepository;
import com.jweiquan.serverwarehouse.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private RuleService ruleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Rule> getList() {
        return this.ruleRepository.findAll();
    }

    @PostMapping("/run")
    public Boolean run(@RequestBody @Validated RuleRunDto body) {
        return this.ruleService.runRuleByIds(body.getRuleIds(), new User());
    }
}
