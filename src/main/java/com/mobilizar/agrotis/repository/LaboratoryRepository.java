package com.mobilizar.agrotis.repository;

import com.mobilizar.agrotis.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

    Laboratory findById(long id);
}
