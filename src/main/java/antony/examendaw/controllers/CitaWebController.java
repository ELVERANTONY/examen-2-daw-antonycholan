package antony.examendaw.controllers;

import antony.examendaw.entities.Cita;
import antony.examendaw.services.CitaService;
import antony.examendaw.services.MedicoService;
import antony.examendaw.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaWebController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    // Listar todas las citas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listarTodas());
        return "cita/listar";
    }

    // Mostrar formulario de creación
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        return "cita/crear";
    }

    // Guardar nueva cita
    @PostMapping
    public String guardar(@ModelAttribute Cita cita,
                          @RequestParam Long pacienteId,
                          @RequestParam Long medicoId) {
        cita.setPaciente(pacienteService.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")));
        cita.setMedico(medicoService.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado")));
        citaService.guardar(cita);
        return "redirect:/citas";
    }

    // Mostrar formulario de edición
    @GetMapping("/actualizar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cita", citaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada")));
        model.addAttribute("pacientes", pacienteService.findAll());
        model.addAttribute("medicos", medicoService.findAll());
        return "cita/editar";
    }

    // Actualizar cita
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Cita cita,
                             @RequestParam Long pacienteId,
                             @RequestParam Long medicoId) {
        cita.setPaciente(pacienteService.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")));
        cita.setMedico(medicoService.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado")));
        citaService.actualizar(cita.getId(), cita);
        return "redirect:/citas";
    }

    // Eliminar cita
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return "redirect:/citas";
    }
}
