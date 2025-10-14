package antony.examendaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import antony.examendaw.entities.Especialidad;
import antony.examendaw.services.EspecialidadService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadWebController {

    @Autowired
    private EspecialidadService especialidadService;

    // 🔹 Listar todas las especialidades
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("especialidades", especialidadService.findAll());
        return "especialidad/listar";
    }

    // 🔹 Mostrar formulario de creación
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("especialidad", new Especialidad());
        return "especialidad/crear";
    }

    // 🔹 Guardar nueva especialidad
    @PostMapping
    public String guardar(@ModelAttribute Especialidad especialidad) {
        especialidadService.save(especialidad);
        return "redirect:/especialidades";
    }

    // 🔹 Mostrar formulario de edición
    @GetMapping("/actualizar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("especialidad", especialidadService.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada")));
        return "especialidad/editar";
    }

    // 🔹 Actualizar especialidad
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Especialidad especialidad) {
        especialidadService.save(especialidad);
        return "redirect:/especialidades";
    }

    // 🔹 Eliminar especialidad
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        especialidadService.delete(id);
        return "redirect:/especialidades";
    }
}
