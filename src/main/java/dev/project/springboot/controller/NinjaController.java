package dev.project.springboot.controller;

import dev.project.springboot.model.NinjaModel;
import dev.project.springboot.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/cadastro")
    @ResponseBody
    public String exibirCadastro(Model model) {
        model.addAttribute("ninja", new NinjaModel());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String salvarNinja(@ModelAttribute NinjaModel ninja,  Model model) {
        ninjaService.saveNinja(ninja);
        return "redirect:/";
    }
}
