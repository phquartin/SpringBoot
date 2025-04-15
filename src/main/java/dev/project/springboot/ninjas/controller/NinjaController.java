package dev.project.springboot.ninjas.controller;

import dev.project.springboot.ninjas.model.NinjaModel;
import dev.project.springboot.ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    // Adicionar Ninja (CREATE)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja Criada com Sucesso!";
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/id")
    public String showNinjasWithId() {
        return "Ninja id!";
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public String showNinjas() {
        return "Ninja Lista!";
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/update")
    public String updateNinjaWithId() {
        return "Ninja Atualizado!";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete")
    public String deleteNinjaWithId() {
        return "Ninja Deletado!";
    }

}
