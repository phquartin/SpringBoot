package dev.project.springboot.missions.controller;

import dev.project.springboot.missions.dto.MissionDTO;
import dev.project.springboot.missions.service.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    private MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    // Adicionar Missao (CREATE)
    @PostMapping("/create")
    public void createMission(@RequestBody MissionDTO mission) {
        missionService.createMission(mission);
    }

    // Procurar Missao por ID (READ)
    @GetMapping("/id/{id}")
    public MissionDTO findMissionById(@PathVariable Long id) {
        return missionService.getMissionById(id);
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/all")
    public List<MissionDTO> findAllMissions() {
        return missionService.getAllMissions();
    }

    // Alterar dados da Missao (UPDATE)
    @PutMapping("/update")
    public void updateMissionById(Long id, MissionDTO missionDTO) {
        missionService.updateMissionById(id, missionDTO);
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteMissionById(@PathVariable Long id) {
        missionService.deleteMissionById(id);
    }

}
