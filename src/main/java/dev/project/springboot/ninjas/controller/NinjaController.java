package dev.project.springboot.ninjas.controller;

import dev.project.springboot.ninjas.dto.NinjaDTO;
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
    public void createNinja(@RequestBody NinjaDTO ninjaDTO) {
        ninjaService.createNinja(ninjaDTO);
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/id/{id}")
    public NinjaDTO getNinjasById(@PathVariable Long id) {
        return ninjaService.getNinjaById(id);
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public List<NinjaDTO> getAllNinjas() {
        return ninjaService.getAllNinjas();
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/update/{id}")
    public void updateNinjaWithId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        ninjaService.updateNinja(ninja, id);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
