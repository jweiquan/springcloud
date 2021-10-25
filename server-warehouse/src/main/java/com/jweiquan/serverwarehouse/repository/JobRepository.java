package com.jweiquan.serverwarehouse.repository;

import com.jweiquan.serverwarehouse.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
