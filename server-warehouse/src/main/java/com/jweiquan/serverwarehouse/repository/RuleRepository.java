package com.jweiquan.serverwarehouse.repository;

import com.jweiquan.serverwarehouse.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RuleRepository extends JpaRepository<Rule, Integer> {
    /**
     *
     * @param id Integer[]
     * @param brandUserId Integer
     * @param active Byte
     * @return RuleList List<Rule>
     */
    List<Rule> findAllByIdInAndBrandUserIdAndActive(Integer[] id, Integer brandUserId, Byte active);
}
