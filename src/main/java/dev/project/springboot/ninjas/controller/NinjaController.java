package dev.project.springboot.ninjas.controller;

import dev.project.springboot.ninjas.model.NinjaModel;
import dev.project.springboot.ninjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    private NinjaController(NinjaService ninjaService) { this.ninjaService = ninjaService; }

    // Adicionar Ninja (CREATE)
    @PostMapping("/create")
    public void createNinja(@RequestBody NinjaModel ninja) {
        ninjaService.createNinja(ninja);
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/id/{id}")
    public NinjaModel getNinjasById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> getAllNinjas() {
        return ninjaService.getAllNinjas();
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
