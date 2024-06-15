package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.jpa.entity.HouseholdApplianceType;
import uptc.frw.aparatoselectronicos.jpa.repository.HouseholdApplianceTypeRepository;

import java.util.List;

@Service
public class HouseholdApplianceTypeService {
  @Autowired
  private HouseholdApplianceTypeRepository householdApplianceTypeRepository;

  public HouseholdApplianceType createHouseholdApplianceType(HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeRepository.save(householdApplianceType);
  }

  public List<HouseholdApplianceType> createHouseholdApplianceTypes(List<HouseholdApplianceType> householdApplianceTypes) {
    return householdApplianceTypeRepository.saveAll(householdApplianceTypes);
  }

  public List<HouseholdApplianceType> findAllHouseholdApplianceTypes() {
    return householdApplianceTypeRepository.findAll();
  }

  public HouseholdApplianceType findHouseholdApplianeTypeById(long id) {
    return householdApplianceTypeRepository.findById(id).orElse(null);
  }

  public HouseholdApplianceType updateHouseholdApplianceType(HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeRepository.save(householdApplianceType);
  }

  public void deleteHouseholdApplianceTypeById(long id) {
    householdApplianceTypeRepository.deleteById(id);
  }
}
