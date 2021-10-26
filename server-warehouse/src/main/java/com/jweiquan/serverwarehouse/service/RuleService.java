package com.jweiquan.serverwarehouse.service;

import com.jweiquan.serverwarehouse.common.ApiException;
import com.jweiquan.serverwarehouse.common.User;
import com.jweiquan.serverwarehouse.entity.Rule;
import com.jweiquan.serverwarehouse.entity.RuleSnapshot;
import com.jweiquan.serverwarehouse.repository.RuleRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        RuleSnapshot ruleSnapshot = new RuleSnapshot();
        ruleSnapshot.setId(rule.getId());
        ruleSnapshot.setName(rule.getName());
        ruleSnapshot.setJobPriority(rule.getJobPriority());
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
        ruleSnapshot.setIsMultiple(rule.getIsMultiple());
        ruleSnapshot.setCarriers(rule.getCarriers());
        ruleSnapshot.setServiceCodes(rule.getServiceCodes());
        if (rule.getAccounts() != null && rule.getServiceCodes() != null) {
            ruleSnapshot.setServiceCodes(rule.getServiceCodes());
            ruleSnapshot.setServices(
                    this.carrierService.getServiceMapByServiceCodes(
                            rule.getServiceCodes(),
                            rule.getAccounts()[0]
                    ).values().toArray(new RuleSnapshot.Service[0])
            );
        }
        ruleSnapshot.setAccounts(rule.getAccounts());
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
        ruleSnapshot.setShipBy(rule.getShipByRange());
        ruleSnapshot.setSku(rule.getSku());
        ruleSnapshot.setMaxOrderQty(rule.getMaxOrderQty());
        ruleSnapshot.setMaxProductQty(rule.getMaxProductQty());
        ruleSnapshot.setMaxProductCategory(rule.getMaxProductCategory());
        if (rule.getShipToCountryCodes() != null) {
            ruleSnapshot.setCountries(
                this.carrierService.getCountryMapByCodes(rule.getShipToCountryCodes()).values().toArray(
                        new RuleSnapshot.Country[0]
                )
            );
        }
        ruleSnapshot.setOrderCreatedAt(rule.getOrderCreatedAt());
        ruleSnapshot.setOptionalConditions(rule.getOptionalConditions());
        return ruleSnapshot;
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
