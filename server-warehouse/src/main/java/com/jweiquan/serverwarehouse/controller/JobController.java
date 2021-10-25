package com.jweiquan.serverwarehouse.controller;

import com.jweiquan.serverwarehouse.entity.Job;
import com.jweiquan.serverwarehouse.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/job")
@ResponseBody
public class JobController {
    @Autowired
    JobRepository jobRepository;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<Job> getJobs() {
        return this.jobRepository.findAll();
    }
}
