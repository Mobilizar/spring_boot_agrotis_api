package com.mobilizar.agrotis.repository;

import com.mobilizar.agrotis.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

    Analysis findById(long id);
}
