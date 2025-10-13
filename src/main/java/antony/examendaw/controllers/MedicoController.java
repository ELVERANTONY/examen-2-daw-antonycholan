package antony.examendaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import antony.examendaw.entities.Medico;
import antony.examendaw.services.MedicoService;
import antony.examendaw.services.EspecialidadService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private EspecialidadService especialidadService;

    // 🔹 Listar todos los médicos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("medicos", medicoService.findAll());
        return "medico/listar";
    }

    // 🔹 Mostrar formulario de creación
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("medico", new Medico());
        model.addAttribute("especialidades", especialidadService.findAll());
        return "medico/crear";
    }

    // 🔹 Guardar nuevo médico
    @PostMapping
    public String guardar(@ModelAttribute Medico medico,
                          @RequestParam(value = "especialidadIds", required = false) java.util.List<Long> especialidadIds) {
        medicoService.guardarConEspecialidades(medico, especialidadIds);
        return "redirect:/medicos";
    }

    // 🔹 Mostrar formulario de edición
    @GetMapping("/actualizar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado")));
        model.addAttribute("especialidades", especialidadService.findAll());
        return "medico/editar";
    }

    // 🔹 Actualizar médico
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Medico medico,
                             @RequestParam(value = "especialidadIds", required = false) java.util.List<Long> especialidadIds) {
        medicoService.actualizarConEspecialidades(medico, especialidadIds);
        return "redirect:/medicos";
    }

    // 🔹 Eliminar médico
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        medicoService.delete(id);
        return "redirect:/medicos";
    }
}
