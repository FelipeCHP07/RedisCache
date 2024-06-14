package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceElectronic;
import uptc.frw.aparatoselectronicos.jpa.entity.Customer;
import uptc.frw.aparatoselectronicos.jpa.entity.Repair;
import uptc.frw.aparatoselectronicos.jpa.repository.RepairRepository;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private ApplianceElectronicService applianceElectronicService;
    @Autowired
    private CustomerService customerService;

    @Cacheable(value = "repairsCache")
    public List<Repair> getRepair(){
        return repairRepository.findAll();
    }

    @Cacheable(value = "repairCache", key = "#id")
    public Repair getRepairById(long id){
        return repairRepository.findById(id).orElse(null);
    }

    @CachePut(value = "repairCache", key = "#repair.id")
    public Repair createRepair(Repair repair){
        ApplianceElectronic applianceElectronic = applianceElectronicService.findApplianceElectronicById(repair.getIdApplianceElectronic());
        Customer customer = customerService.getCustomerById(repair.getIdCustomer());
        repair.setApplianceElectronic(applianceElectronic);
        repair.setCustomer(customer);
        return repairRepository.save(repair);
    }
    @CachePut(value = "repairCache", key = "#newRepair.id")
    public Repair updateRepair(Repair newRepair){
        Repair repair = getRepairById(newRepair.getId());
        repair.setDescription(newRepair.getDescription());
        repair.setDateRepair(newRepair.getDateRepair());
        return repairRepository.save(repair);
    }
    @CacheEvict(value = "repairCache", key = "#id")
    public void deleteRepair(long id){
        repairRepository.deleteById(id);
    }


}
