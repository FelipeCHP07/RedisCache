package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.service.ApplianceElectronicService;

import java.util.List;

@RestController
@RequestMapping("electronicdevice")
public class ApplianceElectronicController {
  @Autowired
  private ApplianceElectronicService applianceElectronicService;

  @GetMapping
  public List<ApplianceElectronic> findAllApplianceElectronics() {
    return applianceElectronicService.findAllApplianceElectronics();
  }

  @GetMapping("/{id}")
  public ApplianceElectronic findApplianceElectronicById(@PathVariable long id) {
    return applianceElectronicService.findApplianceElectronicById(id);
  }

  @PostMapping
  public ApplianceElectronic createApplianceElectronic(@RequestBody ApplianceElectronic applianceElectronic) {
    return applianceElectronicService.createApplianceElectronic(applianceElectronic);
  }

  @PostMapping("/all")
  public List<ApplianceElectronic> createApplianceElectronics(@RequestBody List<ApplianceElectronic> applianceElectronics) {
    return applianceElectronicService.createApplianceElectronics(applianceElectronics);
  }

  @PutMapping
  public ApplianceElectronic updateApplianceElectronic(@RequestBody ApplianceElectronic applianceElectronic) {
    return applianceElectronicService.updateApplianceElectronic(applianceElectronic);
  }

  @DeleteMapping("/{id}")
  public void deleteApplianceElectronic(@PathVariable long id) {
    applianceElectronicService.deleteApplianceElectronic(id);
  }

}
