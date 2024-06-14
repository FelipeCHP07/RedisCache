package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.RepairComponent;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.jpa.entity.Repair;
import uptc.frw.aparatoselectronicos.jpa.repository.RepairComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RepairComponentService {

    @Autowired
    private RepairComponentRepository repairComponentRepository;

    public List<RepairComponent> getAllRepairComponents() {
        return (List<RepairComponent>) repairComponentRepository.findAll();
    }

    public Optional<RepairComponent> getRepairComponentById(Long id) {
        return repairComponentRepository.findById(id);
    }

    public RepairComponent createRepairComponent(RepairComponent repairComponent) {
        return repairComponentRepository.save(repairComponent);
    }

    public RepairComponent updateRepairComponent(Long id, RepairComponent updatedRepairComponent) {
        Optional<RepairComponent> existingRepairComponent = repairComponentRepository.findById(id);
        if (existingRepairComponent.isPresent()) {
            RepairComponent rc = existingRepairComponent.get();
            rc.setRepair(updatedRepairComponent.getRepair());
            rc.setComponent(updatedRepairComponent.getComponent());
            return repairComponentRepository.save(rc);
        }
        return null;
    }

    public void deleteRepairComponent(Long id) {
        repairComponentRepository.deleteById(id);
    }

}
