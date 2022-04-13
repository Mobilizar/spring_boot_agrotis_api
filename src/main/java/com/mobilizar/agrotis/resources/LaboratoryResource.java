package com.mobilizar.agrotis.resources;

import com.mobilizar.agrotis.entity.Laboratory;
import com.mobilizar.agrotis.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LaboratoryResource {

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @GetMapping("/laboratories")
    public List<Laboratory> list(){
        return laboratoryRepository.findAll();
    }

    @GetMapping("/laboratory/{id}")
    public Laboratory findById(@PathVariable(value = "id") long id){
        return laboratoryRepository.findById(id);
    }

    @PostMapping("/laboratory")
    public Laboratory create(@RequestBody Laboratory laboratory){
        return laboratoryRepository.save(laboratory);
    }

    @DeleteMapping("/laboratory")
    public void delete(@RequestBody Laboratory laboratory){
        laboratoryRepository.delete(laboratory);
    }

    @PutMapping("/laboratory")
    public Laboratory update(@RequestBody Laboratory laboratory){
        return laboratoryRepository.save(laboratory);
    }
}
