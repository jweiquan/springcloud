package com.jweiquan.serverwarehouse.controller;

import com.jweiquan.serverwarehouse.entity.Job;
import com.jweiquan.serverwarehouse.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/job")
@ResponseBody
public class JobController {
    @Autowired JobMapper jobMapper;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<Job> getJobs() {
        return this.jobMapper.selectAll();
    }
}
