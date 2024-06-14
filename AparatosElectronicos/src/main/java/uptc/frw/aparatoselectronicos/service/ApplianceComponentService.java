package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceComponent;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.jpa.repository.ApplianceComponentRepository;


import java.util.List;

@Service
public class ApplianceComponentService {
    @Autowired
    private ApplianceComponentRepository applianceComponentRepository;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private ApplianceElectronicService applianceElectronicService;
    @Cacheable(value = "applianceComponentsCache")
    public List<ApplianceComponent> getApplianceComponent(){
        return applianceComponentRepository.findAll();
    }
    @Cacheable(value = "applianceComponentCache", key = "#id")
    public ApplianceComponent getApplianceComponentById(long id){
        return applianceComponentRepository.findById(id).orElse(null);
    }
    @CachePut(value = "applianceComponentCache", key = "#applianceComponent.id")
    public ApplianceComponent createApplianceComponent(ApplianceComponent applianceComponent){
        Component component =componentService.getComponentById(applianceComponent.getIdComponent());
        ApplianceElectronic applianceElectronic = applianceElectronicService.findApplianceElectronicById(applianceComponent.getIdApplianceElectronic());
        applianceComponent.setComponent(component);
        applianceComponent.setApplianceElectronic(applianceElectronic);
        return applianceComponentRepository.save(applianceComponent);
    }
    @CachePut(value = "applianceComponentCache", key = "#newApplianceComponent.id")
    public ApplianceComponent updateApplianceComponent(ApplianceComponent newApplianceComponent){
        ApplianceComponent applianceComponent = getApplianceComponentById(newApplianceComponent.getId());
        applianceComponent.setQuantity(newApplianceComponent.getQuantity());
        applianceComponent.setPrice(newApplianceComponent.getPrice());
        return applianceComponentRepository.save(applianceComponent);
    }
    @CacheEvict(value = "applianceComponentCache", key = "#id")
    public void deleteApplianceComponent(long id){
        applianceComponentRepository.deleteById(id);
    }
}
