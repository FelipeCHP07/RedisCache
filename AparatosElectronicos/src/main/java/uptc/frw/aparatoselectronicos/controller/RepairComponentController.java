package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.RepairComponent;
import uptc.frw.aparatoselectronicos.service.RepairComponentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("repaircomponent")
public class RepairComponentController {

    @Autowired
    private RepairComponentService repairComponentService;

    @GetMapping
    public ResponseEntity<List<RepairComponent>> getAllRepairComponents() {
        List<RepairComponent> repairComponents = repairComponentService.getAllRepairComponents();
        return ResponseEntity.ok(repairComponents);
    }

    @GetMapping("/{id}")
    public RepairComponent getRepairComponentById(@PathVariable long id) {
        return repairComponentService.getRepairComponentById(id);
    }

    @PostMapping
    public ResponseEntity<RepairComponent> createRepairComponent(@RequestBody RepairComponent repairComponent) {
        RepairComponent createdRepairComponent = repairComponentService.createRepairComponent(repairComponent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRepairComponent);
    }

    @PutMapping
    public ResponseEntity<RepairComponent> updateRepairComponent( @RequestBody RepairComponent updatedRepairComponent) {
        RepairComponent updatedComponent = repairComponentService.updateRepairComponent( updatedRepairComponent);
        if (updatedComponent != null) {
            return ResponseEntity.ok(updatedComponent);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepairComponent(@PathVariable long id) {
        repairComponentService.deleteRepairComponent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/component/{component}/repair/{repair}")
    public RepairComponent addComponentToRepair(@PathVariable long component, @PathVariable long repair) {
        return repairComponentService.createRepairComponent(component,repair);
    }
}
