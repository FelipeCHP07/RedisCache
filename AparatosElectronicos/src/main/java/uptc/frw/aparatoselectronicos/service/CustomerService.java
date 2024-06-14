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

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Cacheable(value = "customersCache")
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Cacheable(value = "customerCache", key = "#id")
    public Customer getCustomerById(long id) {
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
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

}
