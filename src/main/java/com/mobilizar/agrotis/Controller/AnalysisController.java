package com.mobilizar.agrotis.Controller;


import com.mobilizar.agrotis.dtos.AnalysisDTO;
import com.mobilizar.agrotis.dtos.LaboratoryDTO;
import com.mobilizar.agrotis.entity.Analysis;
import com.mobilizar.agrotis.entity.Laboratory;
import com.mobilizar.agrotis.services.AnalysisService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class AnalysisController {

    final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/analysis")
    public ResponseEntity<Object> create(@RequestBody @Valid AnalysisDTO analysisDTO){
        var analysis = new Analysis();
        BeanUtils.copyProperties(analysisDTO, analysis);

        return ResponseEntity.status(HttpStatus.CREATED).body(analysisService.save(analysis));
    }

    @GetMapping("/analysis")
    public ResponseEntity<List<Analysis>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(analysisService.listAll());
    }

    @GetMapping("/analysis/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") long id){
        Optional<Analysis> analysisOptional = Optional.ofNullable(analysisService.findById(id));

        if(!analysisOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Analysis not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(analysisOptional.get());
    }

    @DeleteMapping("/analysis/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
        Optional<Analysis> analysisOptional = Optional.ofNullable(analysisService.findById(id));
        if(!analysisOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Analysis not found.");
        }

        analysisService.delete(analysisOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Analysis deleted successfully.");
    }

    @PutMapping("/analysis")
    public ResponseEntity<Object> update(@RequestBody @Valid AnalysisDTO analysisDTO){
        var analysis = new Analysis();
        BeanUtils.copyProperties(analysisDTO, analysis);

        Optional<Analysis> laboratoryOptional = Optional.ofNullable(analysisService.findById(analysis.getId()));
        if(!laboratoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Analysis not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(analysisService.save(analysis));
    }

}
