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
import de.fak73.coronaapi.dto.StateDTO;
import de.fak73.coronaapi.service.StateService;

/**
 * StateController
 */
@Controller
public class StateController {


    @Autowired
    private StateService stateService;
    

    @GetMapping("/api/state")
    public ResponseEntity<List<StateDTO>> getStates(){
        return new ResponseEntity<>(this.stateService.getAllStates(), HttpStatus.OK);
    }
    @PutMapping("/api/state")
    public ResponseEntity<StateDTO> updateState(@RequestBody StateDTO stateDTO){
        return new ResponseEntity<>(this.stateService.updateState(stateDTO), HttpStatus.OK);
    }
    @PostMapping("/api/state")
    public ResponseEntity<StateDTO> saveNewState(@RequestBody StateDTO stateDTO){
        return new ResponseEntity<>(this.stateService.saveNewState(stateDTO), HttpStatus.CREATED);
    }
    @DeleteMapping("/api/state/{stateId}")
    public ResponseEntity<String> deleteState(@PathVariable Long stateId){
        this.stateService.deleteState(stateId);
        return new ResponseEntity<>("State has been deleted", HttpStatus.OK);
    }
    
}