package dev.project.springboot.missions.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mission")
public class MissionController {

    // Adicionar Missao (CREATE)
    @PostMapping("/create")
    public String createMission() {
        return "Missao Criada com Sucesso!";
    }

    // Procurar Missao por ID (READ)
    @GetMapping("/id")
    public String showMissionWithId() {
        return "Mission id!";
    }

    // Mostrar todos as Missoes (READ)
    @GetMapping("/all")
    public String showMissions() {
        return "Missao Lista!";
    }

    // Alterar dados da Missao (UPDATE)
    @PutMapping("/update")
    public String updateMissionWithId() {
        return "Missao Atualizada!";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/delete")
    public String deleteMissionWithId() {
        return "Missao Deletado!";
    }

}
