package uptc.frw.aparatoselectronicos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
