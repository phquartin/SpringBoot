package dev.project.springboot.ninjas.service;

import dev.project.springboot.ninjas.dto.NinjaDTO;
import dev.project.springboot.ninjas.mapper.NinjaMapper;
import dev.project.springboot.ninjas.model.NinjaModel;
import dev.project.springboot.ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<NinjaModel> getAllNinjas() {
        return ninjaRepository.findAll();
    }
    public NinjaModel getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ninja not found"));
    }

    public void updateNinja(NinjaModel ninja, Long id) {
        getNinjaById(id);
        ninja.setId(id);
        ninjaRepository.save(ninja);
    }

    public void deleteNinjaById(Long id) {
        getNinjaById(id);
        ninjaRepository.deleteById(id);
    }

}
