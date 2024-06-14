package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.HouseholdApplianceType;
import uptc.frw.aparatoselectronicos.service.HouseholdApplianceTypeService;

import java.util.List;

@RestController
@RequestMapping("householdappliancetype")
public class HouseholdApplianceTypeController {
  @Autowired
  private HouseholdApplianceTypeService householdApplianceTypeService;

  @GetMapping
  public List<HouseholdApplianceType> findAllHouseholdApplianceTypes(){
    return householdApplianceTypeService.findAllHouseholdApplianceTypes();
  }

  @GetMapping("/{id}")
  public HouseholdApplianceType findHouseholdApplianceTypeById(@PathVariable long id) {
    return householdApplianceTypeService.findHouseholdApplianeTypeById(id);
  }

  @PostMapping
  public HouseholdApplianceType createHouseholdApplianceType(@RequestBody HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeService.createHouseholdApplianceType(householdApplianceType);
  }

  @PostMapping("/all")
  public List<HouseholdApplianceType> createHouseholdApplianceTypes(@RequestBody List<HouseholdApplianceType> householdApplianceTypes) {
    return householdApplianceTypeService.createHouseholdApplianceTypes(householdApplianceTypes);
  }

  @PutMapping
  public HouseholdApplianceType updateHouseholdApplianceType(@RequestBody HouseholdApplianceType householdApplianceType) {
    return householdApplianceTypeService.updateHouseholdApplianceType(householdApplianceType);
  }

  @DeleteMapping("/{id}")
  public void deleteHouseholdApplianceType(@PathVariable long id) {
    householdApplianceTypeService.deleteHouseholdApplianceTypeById(id);
  }
}
