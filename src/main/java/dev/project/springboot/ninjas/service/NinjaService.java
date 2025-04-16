package dev.project.springboot.ninjas.service;

import dev.project.springboot.ninjas.model.NinjaModel;
import dev.project.springboot.ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    private NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    public void createNinja(NinjaModel ninja) {

        if(ninja.getAge() <= 0){
            throw new IllegalArgumentException("Age must be greater than zero");
        }

        ninjaRepository.save(ninja);
    }

    public List<NinjaModel> getAllNinjas() {
        return ninjaRepository.findAll();
    }
    public NinjaModel getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ninja not found"));
    }

}
