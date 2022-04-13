package com.mobilizar.agrotis.resources;

import com.mobilizar.agrotis.entity.Property;
import com.mobilizar.agrotis.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PropertyResource {

    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping("/properties")
    public List<Property> list(){
        return propertyRepository.findAll();
    }

    @GetMapping("/property/{id}")
    public Property findById(@PathVariable(value = "id") long id){
        return propertyRepository.findById(id);
    }

    @PostMapping("/property")
    public Property create(@RequestBody Property property){
        property.setCnpj(property.getCnpj().replaceAll("[^0-9]", ""));

        return propertyRepository.save(property);
    }

    @DeleteMapping("/property")
    public void delete(@RequestBody Property property){
        propertyRepository.delete(property);
    }

    @PutMapping("/property")
    public Property update(@RequestBody Property property){
       return propertyRepository.save(property);
    }
}
