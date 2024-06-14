package uptc.frw.aparatoselectronicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.jpa.repository.ComponentRepository;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;

    public Component getComponentById(long id) {
        return componentRepository.findById(id).orElse(null);
    }
}
