package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.jpa.entity.HouseholdApplianceType;
import uptc.frw.aparatoselectronicos.jpa.repository.ApplianceElectronicRepository;

import java.util.List;

@Service
public class ApplianceElectronicService {
  @Autowired
  private ApplianceElectronicRepository applianceElectronicRepository;
  @Autowired
  private HouseholdApplianceTypeService householdApplianceTypeService;

  @CachePut(value = "applianceElectronicsCache", key = "#applianceElectronic.id")
  public ApplianceElectronic createApplianceElectronic(ApplianceElectronic applianceElectronic) {
    HouseholdApplianceType householdApplianceType = householdApplianceTypeService.findHouseholdApplianeTypeById(applianceElectronic.getIdHouseholdApplianceType());
    applianceElectronic.setHouseholdApplianceType(householdApplianceType);
    return applianceElectronicRepository.save(applianceElectronic);
  }
  @Cacheable(value = "applianceElectronicsCache")
  public List<ApplianceElectronic> createApplianceElectronics(List<ApplianceElectronic> applianceElectronics) {
    return applianceElectronicRepository.saveAll(applianceElectronics);
  }
  @Cacheable(value = "applianceElectronicsCache")
  public List<ApplianceElectronic> findAllApplianceElectronics() {
    return applianceElectronicRepository.findAll();
  }
  @Cacheable(value = "applianceElectronicsCache", key = "#id")
  public ApplianceElectronic findApplianceElectronicById(long id) {
    return applianceElectronicRepository.findById(id).orElse(null);
  }
  @CachePut(value = "applianceElectronicsCache", key = "#applianceElectronic.id")
  public ApplianceElectronic updateApplianceElectronic(ApplianceElectronic applianceElectronic) {
    return applianceElectronicRepository.save(applianceElectronic);
  }
  @CacheEvict(value = "applianceElectronicsCache", key = "#id")
  public void deleteApplianceElectronic(long id) {
    applianceElectronicRepository.deleteById(id);
  }
}