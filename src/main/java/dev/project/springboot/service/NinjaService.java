package dev.project.springboot.service;

import dev.project.springboot.model.NinjaModel;
import dev.project.springboot.repository.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    public void saveNinja(String name, String email, int age) {

        if(age <= 0){
            throw new IllegalArgumentException("Age must be greater than zero");
        }
        NinjaModel ninja = new NinjaModel(name, email, age);

        ninjaRepository.save(ninja);
    }

}
