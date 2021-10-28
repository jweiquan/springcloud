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
     *
     * @param rules List<Rule>
     * @param user User
     * @return Map<Integer, RuleSnapshot>
     */
    public Map<Integer, RuleSnapshot> getRuleSnapshotMapFromRuleList(
            List<Rule> rules,
            @NonNull User user
    ) {
        Map<Integer, RuleSnapshot> ruleSnapshotMap = new HashMap<>();
        if (rules.isEmpty()) {
            return ruleSnapshotMap;
        }

        Set<Integer> allClientIds = new HashSet<>();
        Set<Integer> allWarehouseIds = new HashSet<>();
        Set<String> allServiceCodes = new HashSet<>();
        Set<Integer> allPlatformIds = new HashSet<>();
        Set<Integer> allStoreIds = new HashSet<>();
        Set<String> allCountryCodes = new HashSet<>();


        rules.forEach(rule -> {
            if (rule.getClientIds() != null) {
                allClientIds.addAll(Arrays.asList(rule.getClientIds()));
            }
            allWarehouseIds.add(rule.getWarehouseId());
            if (rule.getServiceCodes() != null) {
                allServiceCodes.addAll(Arrays.asList(rule.getServiceCodes()));
            }
            if (rule.getPlatformIds() != null) {
                allPlatformIds.addAll(Arrays.asList(rule.getPlatformIds()));
            }
            if (rule.getStoreIds() != null) {
                allStoreIds.addAll(Arrays.asList(rule.getStoreIds()));
            }
            if (rule.getShipToCountryCodes() != null) {
                allCountryCodes.addAll(Arrays.asList(rule.getShipToCountryCodes()));
            }
        });

        Map<Integer, RuleSnapshot.Client> clientMap = this.brandUserService.getClientMapByBrandUserIds(allClientIds);
        Map<Integer, RuleSnapshot.Warehouse> warehouseMap = this.warehouseService.getWarehouseIdWarehouseMap(allWarehouseIds, user);
        Map<String, RuleSnapshot.Service> serviceMap = this.carrierService.getServiceMapByServiceCodes(allServiceCodes);
        Map<Integer, RuleSnapshot.Platform> platformMap = this.platformService.getPlatformMapByIds(allPlatformIds, user);
        Map<Integer, RuleSnapshot.Store> storeMap = this.storeService.getStoreMapByIds(allStoreIds, user);
        Map<String, RuleSnapshot.Country> countryMap = this.carrierService.getCountryMapByCodes(allCountryCodes);

        rules.forEach(rule -> {
            RuleSnapshot snapshot = RuleSnapshot.createBaseFromEntity(rule);
            if (rule.getClientIds() != null) {
                List<RuleSnapshot.Client> matchedClients = new LinkedList<>();
                for (Integer id: rule.getClientIds()) {
                    RuleSnapshot.Client client = clientMap.get(id);
                    if (client != null) {
                        matchedClients.add(client);
                    }
                }
                snapshot.setClients(matchedClients.toArray(new RuleSnapshot.Client[0]));
            }
            snapshot.setWarehouse(warehouseMap.get(rule.getWarehouseId()));
            if (rule.getServiceCodes() != null) {
                List<RuleSnapshot.Service> matchedServices = new LinkedList<>();
                for (String serviceCode: rule.getServiceCodes()) {
                    RuleSnapshot.Service service = serviceMap.get(serviceCode);
                    if (service != null) {
                        matchedServices.add(service);
                    }
                }
                snapshot.setServices(matchedServices.toArray(new RuleSnapshot.Service[0]));
            }
            if (rule.getPlatformIds() != null) {
                List<RuleSnapshot.Platform> matchedPlatforms = new LinkedList<>();
                for (Integer id: rule.getPlatformIds()) {
                    RuleSnapshot.Platform platform = platformMap.get(id);
                    if (platform != null) {
                        matchedPlatforms.add(platform);
                    }
                }
                snapshot.setPlatforms(matchedPlatforms.toArray(new RuleSnapshot.Platform[0]));
            }
            if (rule.getStoreIds() != null) {
                List<RuleSnapshot.Store> matchedStores = new LinkedList<>();
                for (Integer id: rule.getStoreIds()) {
                    RuleSnapshot.Store store = storeMap.get(id);
                    if (store != null) {
                        matchedStores.add(store);
                    }
                }
                snapshot.setStores(matchedStores.toArray(new RuleSnapshot.Store[0]));
            }
            if (rule.getShipToCountryCodes() != null) {
                List<RuleSnapshot.Country> matchedCountries = new LinkedList<>();
                for (String countryCode: rule.getShipToCountryCodes()) {
                    RuleSnapshot.Country country = countryMap.get(countryCode);
                    if (country != null) {
                        matchedCountries.add(country);
                    }
                }
                snapshot.setCountries(matchedCountries.toArray(new RuleSnapshot.Country[0]));
            }
        });
        return ruleSnapshotMap;
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

        Map<Integer, RuleSnapshot> ruleSnapshotMap = this.getRuleSnapshotMapFromRuleList(rules, user);
        



        // TODO
        return true;
    }
}
