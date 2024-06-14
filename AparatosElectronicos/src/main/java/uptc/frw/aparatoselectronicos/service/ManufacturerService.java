package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;
import uptc.frw.aparatoselectronicos.jpa.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerService {
  @Autowired
  private ManufacturerRepository manufacturerRepository;
  @CachePut(value = "manufacturerCache", key = "#manufacturer.id")
  public Manufacturer createManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }
  @CachePut(value = "manufacturerCache", key = "#manufacturer.id")
  public List<Manufacturer> createManufacturers(List<Manufacturer> manufacturers) {
    return manufacturerRepository.saveAll(manufacturers);
  }
  @Cacheable(value = "manufacturersCache")
  public List<Manufacturer> findAllManufacturers() {
    return manufacturerRepository.findAll();
  }
  @Cacheable(value = "manufacturerCache", key = "#id")
  public Manufacturer findManufacturerById(long id){
    return manufacturerRepository.findById(id).orElse(null);
  }
  @CachePut(value = "manufacturerCache", key = "#manufacturer.id")
  public Manufacturer updateManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }
  @CacheEvict(value = "manufacturerCache", key = "#id")
  public void deleteManufacturerById(long id) {
    manufacturerRepository.deleteById(id);
  }


}
