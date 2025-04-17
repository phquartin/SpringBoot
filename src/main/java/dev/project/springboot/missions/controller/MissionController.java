package dev.project.springboot.missions.controller;

import dev.project.springboot.missions.dto.MissionDTO;
import dev.project.springboot.missions.service.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createMission(@RequestBody MissionDTO mission) {
        missionService.createMission(mission);
        return ResponseEntity.ok().body("Missao criada com sucesso");
    }

    // Procurar Missao por ID (READ)
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findMissionById(@PathVariable Long id) {
        try {
            MissionDTO missionById = missionService.getMissionById(id);
            return ResponseEntity.ok().body(missionById);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/all")
    public ResponseEntity<List<MissionDTO>> findAllMissions() {
        List<MissionDTO> allMissions = missionService.getAllMissions();
        return ResponseEntity.ok().body(allMissions);
    }

    // Alterar dados da Missao (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMissionById(@PathVariable Long id, @RequestBody MissionDTO missionDTO) {
        try {
            missionService.updateMissionById(id, missionDTO);
            return ResponseEntity.ok().body(missionDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMissionById(@PathVariable Long id) {
        try {
            missionService.deleteMissionById(id);
            return ResponseEntity.ok().body("Missao deletada com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
