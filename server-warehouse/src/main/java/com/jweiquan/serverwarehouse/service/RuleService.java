package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.ApiException;
import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.Rule;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import com.jweiquan.serverwarehouse.repository.RuleRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private BrandUserService brandUserService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CarrierService carrierService;

    /**
     * 创建快照
     */
    public RuleSnapshot createRuleSnapshot(@NonNull Rule rule, @NonNull User user) {
        RuleSnapshot ruleSnapshot = RuleSnapshot.createBaseFromEntity(rule);
        if (rule.getClientIds() != null) {
            ruleSnapshot.setClients(
                    this.brandUserService.getClientMapByBrandUserIds(
                            rule.getClientIds()
                    ).values().toArray(new RuleSnapshot.Client[0])
            );
        }
        if (rule.getWarehouseId() != null) {
            ruleSnapshot.setWarehouse(
                    this.warehouseService.getWarehouseByWarehouseId(rule.getWarehouseId(), user)
            );
        }
        if (rule.getAccounts() != null && rule.getServiceCodes() != null) {
            ruleSnapshot.setServiceCodes(rule.getServiceCodes());
            ruleSnapshot.setServices(
                    this.carrierService.getServiceMapByServiceCodes(
                            rule.getServiceCodes(),
                            rule.getAccounts()[0]
                    ).values().toArray(new RuleSnapshot.Service[0])
            );
        }
        if (rule.getPlatformIds() != null) {
            ruleSnapshot.setPlatforms(
                this.platformService.getPlatformMapByIds(rule.getPlatformIds(), user).values().toArray(
                        new RuleSnapshot.Platform[0]
                )
            );
        }
        if (rule.getStoreIds() != null) {
            ruleSnapshot.setStores(
                this.storeService.getStoreMapByIds(rule.getStoreIds(), user).values().toArray(
                        new RuleSnapshot.Store[0]
                )
            );
        }
        if (rule.getShipToCountryCodes() != null) {
            ruleSnapshot.setCountries(
                this.carrierService.getCountryMapByCodes(rule.getShipToCountryCodes()).values().toArray(
                        new RuleSnapshot.Country[0]
                )
            );
        }
        return ruleSnapshot;
    }

    /**
     *
     * @param rules List<Rule>
     * @param user User
     * @return Map<Integer, RuleSnapshot>
     */
    public Map<Integer, RuleSnapshot> getRuleSnapshotMapFromRuleList(
            List<Rule> rules,
            @NonNull User user
    ) {
        Set<Integer> allClientIds = new HashSet<>();
        Set<Integer> allWarehouseIds = new HashSet<>();
        Set<String> allServiceCodes = new HashSet<>();
        Set<Integer> allPlatformIds = new HashSet<>();
        Set<Integer> allStoreIds = new HashSet<>();
        Set<String> allCountryCodes = new HashSet<>();

        rules.forEach(rule -> {

        });
    }

    /**
     * 执行规则
     * @param ruleIds Integer[]
     * @param user User
     * @return success Boolean
     */
    public Boolean runRuleByIds(@NonNull Integer[] ruleIds,@NonNull User user) {
        Byte isActive = 1;
        List<Rule> rules = this.ruleRepository.findAllByIdInAndBrandUserIdAndActive(ruleIds, user.getBrandUserId(), isActive);
        if (rules.isEmpty()) {
            throw new ApiException(100, "Rules not found!");
        }


        // TODO
        return true;
    }
}
