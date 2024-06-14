package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceComponent;
import uptc.frw.aparatoselectronicos.service.ApplianceComponentService;

import java.util.List;

@RestController
@RequestMapping("appliancecomponet")
public class ApplianceComponentController {
    @Autowired
    private ApplianceComponentService applianceComponentService;
    @GetMapping
    public List<ApplianceComponent> getApplianceComponent(){
        return  applianceComponentService.getApplianceComponent();
    }
    @GetMapping("/{id}")
    public ApplianceComponent getApplianceComponentById(@PathVariable long id){
        return applianceComponentService.getApplianceComponentById(id);
    }
    @PostMapping
    public ApplianceComponent createApplianceComponent(@RequestBody ApplianceComponent applianceComponent){
        return applianceComponentService.createApplianceComponent(applianceComponent);
    }
    @PutMapping
    public ApplianceComponent updateApplianceComponent(@RequestBody ApplianceComponent newApplianceComponent){
        return applianceComponentService.updateApplianceComponent(newApplianceComponent);
    }
    @DeleteMapping("/{id}")
    public void deleteApplianceComponent(@PathVariable long id){
        applianceComponentService.deleteApplianceComponent(id);

    }

    }
