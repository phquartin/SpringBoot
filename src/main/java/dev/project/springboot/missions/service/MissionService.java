package dev.project.springboot.missions.service;

import dev.project.springboot.missions.model.MissionModel;
import dev.project.springboot.missions.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    private final MissionRepository missionRepository;

    private MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public void createMission(MissionModel missionModel) {
        missionRepository.save(missionModel);
    }

    public List<MissionModel> getAllMissions() {
        return missionRepository.findAll();
    }
    public MissionModel getMissionById(Long id) {
        return missionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Mission Not Found"));
    }

    // TODO: update

    public void deleteMissionById(Long id) {
        getMissionById(id);
        missionRepository.deleteById(id);
    }

}
