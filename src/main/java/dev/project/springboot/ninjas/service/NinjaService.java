package dev.project.springboot.ninjas.service;

import dev.project.springboot.ninjas.dto.NinjaDTO;
import dev.project.springboot.ninjas.mapper.NinjaMapper;
import dev.project.springboot.ninjas.model.NinjaModel;
import dev.project.springboot.ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    private NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    public void createNinja(NinjaDTO ninjaDTO) {
        if(ninjaDTO.getAge() <= 0){
            throw new IllegalArgumentException("Age must be greater than zero");
        }
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
    }

    public List<NinjaDTO> getAllNinjas() {
        List<NinjaModel> allNinjas = ninjaRepository.findAll();
        return allNinjas.stream()
                .map(ninjaMapper::map) // Transformando Models em DTO, um por um
                .toList();
    }
    public NinjaDTO getNinjaById(Long id) {
        NinjaModel ninja = ninjaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ninja not found"));
        return ninjaMapper.map(ninja);
    }

    public void updateNinja(NinjaDTO ninjaDTO, Long id) {
        getNinjaById(id);
        ninjaDTO.setId(id);
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
    }

    public void deleteNinjaById(Long id) {
        getNinjaById(id);
        ninjaRepository.deleteById(id);
    }

}
