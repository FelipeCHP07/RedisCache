package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;
import uptc.frw.aparatoselectronicos.jpa.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerService {
  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public Manufacturer createManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }

  public List<Manufacturer> createManufacturers(List<Manufacturer> manufacturers) {
    return manufacturerRepository.saveAll(manufacturers);
  }

  public List<Manufacturer> findAllManufacturers() {
    return manufacturerRepository.findAll();
  }

  public Manufacturer findManufacturerById(long id){
    return manufacturerRepository.findById(id).orElse(null);
  }

  public Manufacturer updateManufacturer(Manufacturer newManufacturer) {
    Manufacturer manufacturer = findManufacturerById(newManufacturer.getId());
    manufacturer.setDomicilio(newManufacturer.getDomicilio());
    manufacturer.setRif(newManufacturer.getRif());
    return manufacturerRepository.save(manufacturer);
  }

  public void deleteManufacturerById(long id) {
    manufacturerRepository.deleteById(id);
  }


}
