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
@RequestMapping("/api/repair-components")
public class RepairComponentController {

    @Autowired
    private RepairComponentService repairComponentService;

    @GetMapping
    public ResponseEntity<List<RepairComponent>> getAllRepairComponents() {
        List<RepairComponent> repairComponents = repairComponentService.getAllRepairComponents();
        return ResponseEntity.ok(repairComponents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairComponent> getRepairComponentById(@PathVariable Long id) {
        Optional<RepairComponent> repairComponent = repairComponentService.getRepairComponentById(id);
        return repairComponent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RepairComponent> createRepairComponent(@RequestBody RepairComponent repairComponent) {
        RepairComponent createdRepairComponent = repairComponentService.createRepairComponent(repairComponent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRepairComponent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepairComponent> updateRepairComponent(@PathVariable Long id, @RequestBody RepairComponent updatedRepairComponent) {
        RepairComponent updatedComponent = repairComponentService.updateRepairComponent(id, updatedRepairComponent);
        if (updatedComponent != null) {
            return ResponseEntity.ok(updatedComponent);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepairComponent(@PathVariable Long id) {
        repairComponentService.deleteRepairComponent(id);
        return ResponseEntity.noContent().build();
    }
}
