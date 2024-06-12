package uptc.frw.aparatoselectronicos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.aparatoselectronicos.jpa.entity.ApplianceComponent;

public interface ApplianceComponentRepository extends JpaRepository<ApplianceComponent, Long> {
}
