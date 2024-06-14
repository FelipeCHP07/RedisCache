package uptc.frw.aparatoselectronicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uptc.frw.aparatoselectronicos.jpa.entity.Component;
import uptc.frw.aparatoselectronicos.service.ComponentService;

import java.util.List;

@RestController
@RequestMapping("component")
public class ComponentController {
    @Autowired
    private ComponentService componentService;
    @GetMapping
    public List<Component> getComponent(){
        return componentService.getComponent();
    }
    @GetMapping("/{id}")
    public Component getComponentById(@PathVariable long id){
        return componentService.getComponentById(id);
    }
    @PostMapping
    public Component createComponent(@RequestBody Component component){
        return componentService.createComponent(component);
    }
    @PutMapping
    public Component updateComponent(@RequestBody Component newComponent){
        return componentService.updateComponent(newComponent);
    }
    @DeleteMapping("/{id}")
    public void deleteCoomponent(@PathVariable long id){
        componentService.deleteCoomponent(id);
    }

    }
