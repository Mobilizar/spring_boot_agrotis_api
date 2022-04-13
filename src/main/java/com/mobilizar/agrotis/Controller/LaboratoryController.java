package com.mobilizar.agrotis.Controller;

import com.mobilizar.agrotis.dtos.LaboratoryDTO;
import com.mobilizar.agrotis.entity.Laboratory;
import com.mobilizar.agrotis.services.LaboratoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LaboratoryController {

    final LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @PostMapping("/laboratory")
    public ResponseEntity<Object> create(@RequestBody @Valid LaboratoryDTO laboratoryDTO){
        var laboratory = new Laboratory();
        BeanUtils.copyProperties(laboratoryDTO, laboratory);

        return ResponseEntity.status(HttpStatus.CREATED).body(laboratoryService.save(laboratory));
    }

    @GetMapping("/laboratories")
    public ResponseEntity<List<Laboratory>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(laboratoryService.listAll());
    }

    @GetMapping("/laboratory/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") long id){
        Optional<Laboratory> laboratoryOptional = Optional.ofNullable(laboratoryService.findById(id));

        if(!laboratoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratory not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(laboratoryOptional.get());
    }

    @DeleteMapping("/laboratory/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id){
        Optional<Laboratory> laboratoryOptional = Optional.ofNullable(laboratoryService.findById(id));
        if(!laboratoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratory not found.");
        }

        laboratoryService.delete(laboratoryOptional.get());
       return ResponseEntity.status(HttpStatus.OK).body("Laboratory deleted successfully.");
    }

    @PutMapping("/laboratory")
    public ResponseEntity<Object> update(@RequestBody @Valid LaboratoryDTO laboratoryDTO){
        var laboratory = new Laboratory();
        BeanUtils.copyProperties(laboratoryDTO, laboratory);

        Optional<Laboratory> laboratoryOptional = Optional.ofNullable(laboratoryService.findById(laboratory.getId()));
        if(!laboratoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratory not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(laboratoryService.save(laboratory));
    }
}
