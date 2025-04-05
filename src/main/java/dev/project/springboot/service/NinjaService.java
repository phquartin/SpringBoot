package dev.project.springboot.service;

import dev.project.springboot.model.NinjaModel;
import dev.project.springboot.repository.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    private NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    public void saveNinja(NinjaModel ninja) {

        if(ninja.getAge() <= 0){
            throw new IllegalArgumentException("Age must be greater than zero");
        }

        ninjaRepository.save(ninja);
    }

}
