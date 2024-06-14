package uptc.frw.aparatoselectronicos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.aparatoselectronicos.jpa.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
