package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
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

  public ApplianceElectronic createApplianceElectronic(ApplianceElectronic applianceElectronic) {
    HouseholdApplianceType householdApplianceType = householdApplianceTypeService.findHouseholdApplianeTypeById(applianceElectronic.getIdHouseholdApplianceType());
    applianceElectronic.setHouseholdApplianceType(householdApplianceType);
    return applianceElectronicRepository.save(applianceElectronic);
  }

  public List<ApplianceElectronic> createApplianceElectronics(List<ApplianceElectronic> applianceElectronics) {
    return applianceElectronicRepository.saveAll(applianceElectronics);
  }

  public List<ApplianceElectronic> findAllApplianceElectronics() {
    return applianceElectronicRepository.findAll();
  }

  public ApplianceElectronic findApplianceElectronicById(long id) {
    return applianceElectronicRepository.findById(id).orElse(null);
  }

  public ApplianceElectronic updateApplianceElectronic(ApplianceElectronic newApplianceElectronic) {
    ApplianceElectronic applianceElectronic = findApplianceElectronicById(newApplianceElectronic.getId());
    applianceElectronic.setDescription(newApplianceElectronic.getDescription());
    return applianceElectronicRepository.save(applianceElectronic);
  }

  public void deleteApplianceElectronic(long id) {
    applianceElectronicRepository.deleteById(id);
  }
}