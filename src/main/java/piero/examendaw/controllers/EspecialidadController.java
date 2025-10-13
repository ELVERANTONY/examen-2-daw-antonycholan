package piero.examendaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import piero.examendaw.entities.Especialidad;
import piero.examendaw.errors.EspecialidadError;
import piero.examendaw.services.EspecialidadServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadServiceImpl especialidadService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("especialidades", especialidadService.findAll());
        return "especialidad/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("especialidad", new Especialidad());
        return "especialidad/crear";
    }

    @PostMapping
    public String guardar(@ModelAttribute Especialidad especialidad) {
        especialidadService.save(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/actualizar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Especialidad especialidad = especialidadService.findById(id)
                .orElseThrow(() -> new EspecialidadError("Especialidad no encontrada"));
        model.addAttribute("especialidad", especialidad);
        return "especialidad/editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Especialidad especialidad) {
        especialidadService.save(especialidad);
        return "redirect:/especialidades";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        especialidadService.delete(id);
        return "redirect:/especialidades";
    }
}
