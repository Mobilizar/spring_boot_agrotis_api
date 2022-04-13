package com.mobilizar.agrotis.services;

import com.mobilizar.agrotis.entity.Analysis;
import com.mobilizar.agrotis.repository.AnalysisRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnalysisService {

    final AnalysisRepository analysisRepository;

    public AnalysisService(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Transactional
    public Analysis save(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    public List<Analysis> listAll(){
        return analysisRepository.findAll();
    }

    public Analysis findById(long id){
        return analysisRepository.findById(id);
    }

    @Transactional
    public void delete(Analysis analysis){
        analysisRepository.delete(analysis);
    }
}
