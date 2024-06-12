package uptc.frw.aparatoselectronicos.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.aparatoselectronicos.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
