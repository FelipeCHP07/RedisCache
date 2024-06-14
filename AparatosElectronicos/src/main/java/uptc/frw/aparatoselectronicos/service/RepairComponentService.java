package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.RepairComponent;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.jpa.entity.Repair;
import uptc.frw.aparatoselectronicos.jpa.repository.ComponentRepository;
import uptc.frw.aparatoselectronicos.jpa.repository.RepairComponentRepository;


import java.util.List;


@Service
public class RepairComponentService {

    @Autowired
    private RepairComponentRepository repairComponentRepository;
    @Autowired
    private RepairService repairService;

    @Autowired
    private ComponentService componentService;
    @Autowired
    private ComponentRepository componentRepository;
    @Cacheable(value = "repairComponentsCache")
    public List<RepairComponent> getAllRepairComponents() {
        return repairComponentRepository.findAll();
    }
    @Cacheable(value = "repairComponentCache", key = "#id")
    public RepairComponent getRepairComponentById(long id) {
        return repairComponentRepository.findById(id).orElse(null);
    }

    @CachePut(value = "repairComponentCache", key = "#repairComponent.id")
    public RepairComponent createRepairComponent(RepairComponent repairComponent) {
        return repairComponentRepository.save(repairComponent);
    }

    @CachePut(value = "repairComponentCache", key = "#id")
    public RepairComponent updateRepairComponent(RepairComponent updatedRepairComponent) {
       RepairComponent repairComponent = getRepairComponentById(updatedRepairComponent.getId());
       return repairComponentRepository.save(repairComponent);
    }

    @CacheEvict(value = "repairComponentCache", key = "#id")
    public void deleteRepairComponent(Long id) {
        repairComponentRepository.deleteById(id);
    }

    @CachePut(value = "repairComponentCache", key = "#result.id")
    public RepairComponent createRepairComponent (long idComp, long idRepair){
        Repair repair = repairService.getRepairById(idRepair);
        Component component = componentService.getComponentById(idComp);
        RepairComponent repairComponent = new RepairComponent();
        repairComponent.setComponent(component);
        repairComponent.setRepair(repair);
        return repairComponentRepository.save(repairComponent);
    }



}
