package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;
import uptc.frw.aparatoselectronicos.jpa.repository.ComponentRepository;

import java.util.List;
//@Cacheable: Es utilizado para almacenar el resultado de la llamada al método en la caché.
//@CachePut: Es utilizado para actualizar uno o más elementos de la caché.
//@CacheEvict: Es utilizado para eliminar uno o más elementos obsoletos de la caché.
//@Caching: Es utilizado para agrupar las anotaciones anteriores, simplificando la configuración.
@Service
public class ComponentService {
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ManufacturerService manufacturerService;
    @Cacheable(value = "componentCache")
    public List<Component> getComponent(){
        return componentRepository.findAll();
    }
    @Cacheable(value = "componentCache", key = "#id")
    public Component getComponentById(long id){
        return componentRepository.findById(id).orElse(null);
    }
    @Caching(
            put = {
                    @CachePut(value = "componentCache", key = "#component.id"),
                    @CachePut(value = "componentCache")
            }
    )
    //@CachePut(value = "componentCache", key = "#component.id")
    public Component createComponent(Component component){
        Manufacturer manufacturer = manufacturerService.findManufacturerById(component.getIdManufacturer());
        component.setManufacturer(manufacturer);
        return componentRepository.save(component);
    }

    @Caching(
            put = {
                    @CachePut(value = "componentCache", key = "#newComponent.id"),
                    @CachePut(value = "componentCache")
            }
    )
   // @CachePut(value = "componentCache", key = "#newComponent.id")
    public Component updateComponent(Component newComponent){
        Component component = getComponentById(newComponent.getId());
        component.setName(newComponent.getName());
        component.setSpecifications(newComponent.getSpecifications());
        return componentRepository.save(component);
    }
    @Caching(
            evict = {
                    @CacheEvict(value = "componentCache", key = "#id"),
                    @CacheEvict(value = "componentCache", allEntries = true)
            }
    )
    //@CacheEvict(value = "componentCache", key = "#id")
    public void deleteCoomponent(long id){
        componentRepository.deleteById(id);
    }
}
