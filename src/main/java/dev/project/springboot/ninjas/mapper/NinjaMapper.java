package dev.project.springboot.ninjas.mapper;

import dev.project.springboot.ninjas.dto.NinjaDTO;
import dev.project.springboot.ninjas.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setSkills(ninjaDTO.getSkills());
        ninjaModel.setMission(ninjaDTO.getMission());
        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setSkills(ninjaModel.getSkills());
        ninjaDTO.setMission(ninjaModel.getMission());
        return ninjaDTO;
    }

}
