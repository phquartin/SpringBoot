package dev.project.springboot.missions.mapper;

import dev.project.springboot.missions.dto.MissionDTO;
import dev.project.springboot.missions.model.MissionModel;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionDTO map(MissionModel missionModel){
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setRank(missionModel.getRank());
        return missionDTO;
    }
    public MissionModel map(MissionDTO missionDTO){
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setRank(missionDTO.getRank());
        return missionModel;
    }

}
