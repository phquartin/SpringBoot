package dev.project.springboot.ninjas.controller;

import dev.project.springboot.ninjas.dto.NinjaDTO;
import dev.project.springboot.ninjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    private NinjaController(NinjaService ninjaService) { this.ninjaService = ninjaService; }

    // Adicionar Ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO) {
        ninjaService.createNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja '"+ ninjaDTO.getName() +"' Criado com sucesso!");
    }

    // Procurar Ninja por ID (READ)
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getNinjasById(@PathVariable Long id) {
        try {
            NinjaDTO ninjaById = ninjaService.getNinjaById(id);
            return ResponseEntity.ok().body(ninjaById);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> getAllNinjas() {
        List<NinjaDTO> allNinjas = ninjaService.getAllNinjas();
        return ResponseEntity.ok(allNinjas);
    }

    // Alterar dados do Ninja (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinjaWithId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        try {
            ninjaService.updateNinja(ninja, id);
            return ResponseEntity.ok().body(ninja);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinjaById(@PathVariable Long id) {
        try {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok().body("Ninja com o ID '"+ id +"' deletado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
