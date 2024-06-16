package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.Customer;
import uptc.frw.aparatoselectronicos.jpa.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
//@Cacheable: Es utilizado para almacenar el resultado de la llamada al método en la caché.
//@CacheEvict: Es utilizado para eliminar uno o más elementos obsoletos de la caché.
//@CachePut: Es utilizado para actualizar uno o más elementos de la caché.
//@Caching: Es utilizado para agrupar las anotaciones anteriores, simplificando la configuración.
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Cacheable(value = "customersCache")
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Cacheable(value = "customer",key = "'all'")
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElse(null);
    }
    @CachePut(value = "customerCache", key = "#customer.id")
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @CachePut(value = "customerCache", key = "#updatedCustomer.id")
    public Customer updateCustomer( Customer updatedCustomer) {
        Customer customer = getCustomerById(updatedCustomer.getId());
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setDocumentNumber(updatedCustomer.getDocumentNumber());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhone(updatedCustomer.getPhone());
        customer.setEmail(updatedCustomer.getEmail());
        return customerRepository.save(customer);
    }
    @CacheEvict(value = "customerCache", key = "#id")
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void createNCustomers(long n){
        // Arreglo de Names
        String[] names = {
            "Juan", "María", "Pedro", "Ana", "Luis",
            "Laura", "Carlos", "Sofía", "Diego", "Valeria"
        };

        // Arreglo de LastNames
        String[] lastNames = {
            "Pérez", "Gómez", "Martínez", "López", "González",
            "Rodríguez", "Sánchez", "Torres", "Ramírez", "Díaz"
        };

        // Arreglo de ids
        String[] identifications = {
            "12345678", "87654321", "45678901", "23456789", "89012345",
            "54321678", "67890123", "32109876", "78901234", "45678123"
        };

        // Arreglo de direcciones
        String[] addresses = {
            "Av. Principal 123", "Calle Secundaria 456", "Ruta Periférica 789",
            "Pasaje Interno 234", "Avenida Central 567", "Callejón Pequeño 890",
            "Camino Largo 321", "Plaza Mayor 876", "Boulevard Elegante 901",
            "Carrera Veloz 543"
        };

        // Arreglo de teléfonos
        String[] phones = {
            "5551234", "5555678", "5559012", "5553456", "5557890",
            "5552345", "5556789", "5558901", "5554321", "5557789"
        };

        // Arreglo de correos electrónicos
        String[] emails = {
            "juanperez@example.com", "mariagomez@example.com",
            "pedromartinez@example.com", "analopez@example.com",
            "luisgonzalez@example.com", "lararodriguez@example.com",
            "carlossanchez@example.com", "sofiatorres@example.com",
            "diegoramirez@example.com", "valeriadiaz@example.com"
        };
        for (int i = 0; i < n; i++) {
            int randNumberName = (int) (Math.random() * names.length);
            int randNumberLastName = (int) (Math.random() * lastNames.length);
            int randNumberIdentification = (int) (Math.random() * identifications.length);
            int randNumberAddress = (int) (Math.random() * addresses.length);
            int randNumberPhone = (int) (Math.random() * phones.length);
            int randNumberEmail = (int) (Math.random() * emails.length);
            Customer customer = new Customer();
            customer.setFirstName(names[randNumberName]);
            customer.setLastName(lastNames[randNumberLastName]);
            customer.setDocumentNumber(identifications[randNumberIdentification]);
            customer.setAddress(addresses[randNumberAddress]);
            customer.setPhone(phones[randNumberPhone]);
            customer.setEmail(emails[randNumberEmail]);
            createCustomer(customer);
        }
    }

}
