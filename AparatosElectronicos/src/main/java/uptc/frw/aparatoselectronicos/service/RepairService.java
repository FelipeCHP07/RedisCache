package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Repair> getRepair(){
        return repairRepository.findAll();
    }

    public Repair getRepairById(long id){
        return repairRepository.findById(id).orElse(null);
    }
    public Repair createRepair(Repair repair){
        ApplianceElectronic applianceElectronic = applianceElectronicService.findApplianceElectronicById(repair.getIdApplianceElectronic());
        Customer customer = customerService.getCustomerById(repair.getIdCustomer());
        repair.setApplianceElectronic(applianceElectronic);
        repair.setCustomer(customer);
        return repairRepository.save(repair);
    }
    public Repair updateRepair(Repair newRepair){
        Repair repair = getRepairById(newRepair.getId());
        repair.setDescription(newRepair.getDescription());
        repair.setDateRepair(newRepair.getDateRepair());
        return repairRepository.save(repair);
    }
    public void deleteRepair(long id){
        repairRepository.deleteById(id);
    }


}
