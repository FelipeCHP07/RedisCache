package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceComponent;
import uptc.frw.aparatoselectronicos.jpa.repository.ApplianceComponentRepository;


import java.util.List;

@Service
public class ApplianceComponentService {
    @Autowired
    private ApplianceComponentRepository applianceComponentRepository;
    @Autowired
    private ComponentService componentService;

    public List<ApplianceComponent> getApplianceComponent(){
        return applianceComponentRepository.findAll();
    }

    public ApplianceComponent getApplianceComponentById(long id){
        return applianceComponentRepository.findById(id).orElse(null);
    }

    public ApplianceComponent createApplianceComponent(ApplianceComponent applianceComponent){
        return applianceComponentRepository.save(applianceComponent);
    }

    public ApplianceComponent updateApplianceComponent(ApplianceComponent newApplianceComponent){
        ApplianceComponent applianceComponent = getApplianceComponentById(newApplianceComponent.getId());
        applianceComponent.setQuantity(newApplianceComponent.getQuantity());
        applianceComponent.setPrice(newApplianceComponent.getPrice());
        return applianceComponentRepository.save(applianceComponent);
    }

    public void deleteApplianceComponent(long id){
        applianceComponentRepository.deleteById(id);
    }
}
