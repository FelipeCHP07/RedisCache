package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.jpa.entity.HouseholdApplianceType;
import uptc.frw.aparatoselectronicos.jpa.repository.HouseholdApplianceTypeRepository;

import java.util.List;

@Service
public class HouseholdApplianceTypeService {
  @Autowired
  private HouseholdApplianceTypeRepository householdApplianceTypeRepository;
  @CachePut(value = "householdApplianceTypeCache", key = "#householdApplianceType.id")
  public HouseholdApplianceType createHouseholdApplianceType(HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeRepository.save(householdApplianceType);
  }
  @CachePut(value = "householdApplianceTypeCache", key = "#householdApplianceType.id")
  public List<HouseholdApplianceType> createHouseholdApplianceTypes(List<HouseholdApplianceType> householdApplianceTypes) {
    return householdApplianceTypeRepository.saveAll(householdApplianceTypes);
  }
  @Cacheable(value = "householdApplianceTypesCache")
  public List<HouseholdApplianceType> findAllHouseholdApplianceTypes() {
    return householdApplianceTypeRepository.findAll();
  }
  @Cacheable(value = "householdApplianceTypeCache", key = "#id")
  public HouseholdApplianceType findHouseholdApplianeTypeById(long id) {
    return householdApplianceTypeRepository.findById(id).orElse(null);
  }
  @CachePut(value = "householdApplianceTypeCache", key = "#householdApplianceType.id")
  public HouseholdApplianceType updateHouseholdApplianceType(HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeRepository.save(householdApplianceType);
  }
  @CacheEvict(value = "householdApplianceTypeCache", key = "#id")
  public void deleteHouseholdApplianceTypeById(long id) {
    householdApplianceTypeRepository.deleteById(id);
  }
}
