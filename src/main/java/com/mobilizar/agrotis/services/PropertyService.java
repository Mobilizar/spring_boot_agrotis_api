package com.mobilizar.agrotis.services;

import com.mobilizar.agrotis.entity.Property;
import com.mobilizar.agrotis.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PropertyService {

    final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public Property save(Property propert) {
        return propertyRepository.save(propert);
    }

    public List<Property> listAll(){
        return propertyRepository.findAll();
    }

    public Property findById(long id){
        return propertyRepository.findById(id);
    }

    @Transactional
    public void delete(Property property){
        propertyRepository.delete(property);
    }
}
