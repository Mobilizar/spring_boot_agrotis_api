package com.mobilizar.agrotis.Controller;


import com.mobilizar.agrotis.dtos.PropertyDTO;
import com.mobilizar.agrotis.entity.Property;
import com.mobilizar.agrotis.services.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class PropertyController {

    final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping("/property")
    public ResponseEntity<Object> create(@RequestBody @Valid PropertyDTO propertyDTO){
        var property = new Property();
        BeanUtils.copyProperties(propertyDTO, property);

        property.setCnpj(property.getCnpj().replaceAll("[^0-9]", ""));

        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.save(property));
    }

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.listAll());
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") long id){
        Optional<Property> propertyOptional = Optional.ofNullable(propertyService.findById(id));

        if(!propertyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(propertyOptional.get());
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
        Optional<Property> propertyOptional = Optional.ofNullable(propertyService.findById(id));
        if(!propertyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }

        propertyService.delete(propertyOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Property deleted successfully.");
    }


    @PutMapping("/property")
    public ResponseEntity<Object> update(@RequestBody @Valid PropertyDTO propertyDTO){
        var property = new Property();
        BeanUtils.copyProperties(propertyDTO, property);

        Optional<Property> propertyOptional = Optional.ofNullable(propertyService.findById(property.getId()));
        if(!propertyOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }

        property.setCnpj(property.getCnpj().replaceAll("[^0-9]", ""));

        return ResponseEntity.status(HttpStatus.OK).body(propertyService.save(property));
    }
}
