package com.mobilizar.agrotis.resources;

import com.mobilizar.agrotis.entity.Analysis;
import com.mobilizar.agrotis.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AnalysisResource {

    @Autowired
    AnalysisRepository analysisRepository;

    @GetMapping("/analysis")
    public List<Analysis> list(){
        return analysisRepository.findAll();
    }

    @GetMapping("/analysis/{id}")
    public Analysis findById(@PathVariable(value = "id") long id){
        return analysisRepository.findById(id);
    }

    @PostMapping("/analysis")
    public Analysis create(@RequestBody Analysis analysis){
        return analysisRepository.save(analysis);
    }

    @DeleteMapping("/analysis")
    public void delete(@RequestBody Analysis analysis){
        analysisRepository.delete(analysis);
    }

    @PutMapping("/analysis")
    public Analysis update(@RequestBody Analysis analysis){
        return analysisRepository.save(analysis);
    }

}
