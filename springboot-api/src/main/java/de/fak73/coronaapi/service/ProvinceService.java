package de.fak73.coronaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fak73.coronaapi.dto.ProvinceDTO;
import de.fak73.coronaapi.model.Province;
import de.fak73.coronaapi.repository.ProvinceRepository;

/**
 * StateController
 */
@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<ProvinceDTO> getAllProvinces() {
        return this.provinceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public ProvinceDTO saveNewProvince(ProvinceDTO provinceDTO) {   
        Province newProvince = new Province();
        newProvince.setInformation(provinceDTO.getInformation());
        return this.convertToDTO(this.provinceRepository.save(newProvince));
    }

    public ProvinceDTO updateProvince(ProvinceDTO provinceDTO) {
        Optional<Province> requestedProvince  = this.provinceRepository.findById(provinceDTO.getId());
        if (provinceDTO.getId() != null && requestedProvince.get() != null) {
            Province toBeUpdated =  requestedProvince.get();
            toBeUpdated.setInformation(provinceDTO.getInformation());
            this.provinceRepository.saveAndFlush(toBeUpdated);
            return this.convertToDTO(toBeUpdated);
        }
        else {
            throw new IllegalArgumentException("Element with id " + provinceDTO.getId() + " not found!");
        }
    }

    public void deleteProvince(Long provinceId) {
        this.provinceRepository.deleteById(provinceId);
    }
    
    private ProvinceDTO convertToDTO(Province province) {
        ProvinceDTO result = new ProvinceDTO();
        result.setId(province.getId());
        result.setInformation(province.getInformation());
        return result;
    }

}