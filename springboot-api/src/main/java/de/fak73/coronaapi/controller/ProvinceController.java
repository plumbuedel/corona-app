package de.fak73.coronaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import de.fak73.coronaapi.dto.ProvinceDTO;
import de.fak73.coronaapi.service.ProvinceService;

/**
 * StateController
 */
@Controller
@RequestMapping("/api/province")
public class ProvinceController {


    @Autowired
    private ProvinceService provinceService;
    

    @GetMapping()
    public ResponseEntity<List<ProvinceDTO>> getStates(){
        return new ResponseEntity<>(this.provinceService.getAllProvinces(), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<ProvinceDTO> updateState(@RequestBody ProvinceDTO stateDTO){
        return new ResponseEntity<>(this.provinceService.updateProvince(stateDTO), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ProvinceDTO> saveNewState(@RequestBody ProvinceDTO stateDTO){
        return new ResponseEntity<>(this.provinceService.saveNewProvince(stateDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("/{provinceId}")
    public ResponseEntity<String> deleteState(@PathVariable Long provinceId){
        this.provinceService.deleteProvince(provinceId);
        return new ResponseEntity<>("State has been deleted", HttpStatus.OK);
    }
    
}