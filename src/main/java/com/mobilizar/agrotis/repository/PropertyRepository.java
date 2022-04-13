package com.mobilizar.agrotis.repository;

import com.mobilizar.agrotis.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findById(long id);

}
