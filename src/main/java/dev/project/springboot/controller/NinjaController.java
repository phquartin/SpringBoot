package dev.project.springboot.controller;

import dev.project.springboot.model.NinjaModel;
import dev.project.springboot.repository.NinjaRepository;
import dev.project.springboot.service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/cadastro")
    public String exibirCadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarNinja(@RequestParam String nome, @RequestParam String email, @RequestParam int idade) {
        ninjaService.saveNinja(nome, email, idade);
        return "index";
    }
}
