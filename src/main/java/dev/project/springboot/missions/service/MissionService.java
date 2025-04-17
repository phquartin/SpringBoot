package dev.project.springboot.missions.service;

import dev.project.springboot.missions.dto.MissionDTO;
import dev.project.springboot.missions.mapper.MissionMapper;
import dev.project.springboot.missions.model.MissionModel;
import dev.project.springboot.missions.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    private MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public void createMission(MissionDTO missionDTO) {
        MissionModel mission = missionMapper.map(missionDTO);
        missionRepository.save(mission);
    }

    public List<MissionDTO> getAllMissions() {
        List<MissionModel> allMissions = missionRepository.findAll();
        return allMissions.stream()
                .map(missionMapper::map)
                .toList();
    }
    public MissionDTO getMissionById(Long id) {
        MissionModel mission = missionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Mission Not Found"));
        return missionMapper.map(mission);
    }

    public void updateMissionById(Long id, MissionDTO missionDTO) {
        getMissionById(id);
        missionDTO.setId(id);
        MissionModel mission = missionMapper.map(missionDTO);
        missionRepository.save(mission);
    }

    public void deleteMissionById(Long id) {
        getMissionById(id);
        missionRepository.deleteById(id);
    }

}
