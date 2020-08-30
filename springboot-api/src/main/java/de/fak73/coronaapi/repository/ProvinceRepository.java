package de.fak73.coronaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.fak73.coronaapi.model.Province;

/**
 * StateRepository
 */
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
        
}