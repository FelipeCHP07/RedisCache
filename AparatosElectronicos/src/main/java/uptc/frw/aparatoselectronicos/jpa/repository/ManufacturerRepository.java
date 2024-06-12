package uptc.frw.aparatoselectronicos.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
