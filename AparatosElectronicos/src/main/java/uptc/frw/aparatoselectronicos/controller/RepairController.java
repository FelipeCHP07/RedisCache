package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.Repair;
import uptc.frw.aparatoselectronicos.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("repair")
public class RepairController {
    @Autowired
    private RepairService  repairService;

    @GetMapping
    public List<Repair> getRepair(){
        return repairService.getRepair();
    }

    @GetMapping("/{id}")
    public Repair getRepairById(@PathVariable long id){
        return repairService.getRepairById(id);
    }
    @PostMapping
    public Repair createRepair(@RequestBody Repair repair){
        return repairService.createRepair(repair);
    }
    @PutMapping
    public Repair updateRepair(@RequestBody Repair newRepair){
        return repairService.updateRepair(newRepair);

    }
    @DeleteMapping("/{id}")
    public void deleteRepair(@PathVariable long id){
        repairService.deleteRepair(id);
    }


}
