package de.fak73.coronaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fak73.coronaapi.model.State;

/**
 * StateRepository
 */
public interface StateRepository extends JpaRepository<State, Long> {
        
}