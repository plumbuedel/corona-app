package de.fak73.coronaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fak73.coronaapi.dto.StateDTO;
import de.fak73.coronaapi.model.State;
import de.fak73.coronaapi.repository.StateRepository;

/**
 * StateController
 */
@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<StateDTO> getAllStates() {
        return this.stateRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public StateDTO saveNewState(StateDTO stateDTO) {   
        State newState = this.convertToEntity(stateDTO);
        return this.convertToDTO(this.stateRepository.save(newState));
    }

    public StateDTO updateState(StateDTO stateDTO) {
        Optional<State> requestedState  = this.stateRepository.findById(stateDTO.getId());
        if (stateDTO.getId() != null && requestedState.get() != null) {
            State toBeUpdated =  requestedState.get();
            toBeUpdated.setInformation(stateDTO.getInformation());
            this.stateRepository.saveAndFlush(toBeUpdated);
            return this.convertToDTO(toBeUpdated);
        }
        else {
            throw new IllegalArgumentException("Element with id " + stateDTO.getId() + " not found!");
        }
    }

    public void deleteState(Long stateId) {
        this.stateRepository.deleteById(stateId);
    }
    
    private StateDTO convertToDTO(State state) {
        StateDTO result = new StateDTO();
        result.setId(state.getId());
        result.setInformation(state.getInformation());
        return result;
    }

    private State convertToEntity(StateDTO stateDTO) {
        State result = new State();
        result.setId(stateDTO.getId());
        result.setInformation(stateDTO.getInformation());
        return result;
    }
}