package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;
import uptc.frw.aparatoselectronicos.service.ManufacturerService;

import java.util.List;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
  @Autowired
  private ManufacturerService manufacturerService;

  @GetMapping
  public List<Manufacturer> findAllManufacturers() {
    return manufacturerService.findAllManufacturers();
  }

  @GetMapping("/{id}")
  public Manufacturer findManufacturerById(@PathVariable long id) {
    return manufacturerService.findManufacturerById(id);
  }

  @PostMapping
  public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
    return manufacturerService.createManufacturer(manufacturer);
  }

  @PostMapping("/all")
  public List<Manufacturer> createManufacturers(@RequestBody List<Manufacturer> manufacturers) {
    return manufacturerService.createManufacturers(manufacturers);
  }

  @PutMapping
  public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
    return manufacturerService.updateManufacturer(manufacturer);
  }

  @DeleteMapping("/{id}")
  public void deleteManufacturerById(@PathVariable long id) {
    manufacturerService.deleteManufacturerById(id);
  }

}
