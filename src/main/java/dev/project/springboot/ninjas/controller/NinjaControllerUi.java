package dev.project.springboot.ninjas.controller;

import dev.project.springboot.ninjas.dto.NinjaDTO;
import dev.project.springboot.ninjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    private NinjaControllerUi(NinjaService ninjaService) { this.ninjaService = ninjaService; }

    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "addNinja";
    }

    @PostMapping("/save")
    public String createNinja(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes) {
        ninjaService.createNinja(ninjaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja guardado");
        return "redirect:/ninja/ui/all";
    }

    @GetMapping("/all")
    public String getAllNinjas(Model model) {
        List<NinjaDTO> allNinjas = ninjaService.getAllNinjas();
        model.addAttribute("ninjas", allNinjas);
        return "listNinjas";
    }

    @GetMapping("/delete/{id}")
    public String deleteNinjaById(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
        return "redirect:/ninja/ui/all";
    }


}
