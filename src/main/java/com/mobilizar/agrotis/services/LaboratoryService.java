package com.mobilizar.agrotis.services;

import com.mobilizar.agrotis.entity.Laboratory;
import com.mobilizar.agrotis.repository.LaboratoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LaboratoryService {

    final LaboratoryRepository laboratoryRepository;

    public LaboratoryService(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @Transactional
    public Laboratory save(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    public List<Laboratory> listAll(){
        return laboratoryRepository.findAll();
    }

    public Laboratory findById(long id){
        return laboratoryRepository.findById(id);
    }

    @Transactional
    public void delete(Laboratory laboratory){
        laboratoryRepository.delete(laboratory);
    }

}
