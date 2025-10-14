package antony.examendaw.controllers;

import antony.examendaw.entities.AntecedenteMedico;
import antony.examendaw.entities.Paciente;
import antony.examendaw.repositories.AntecedenteRepository;
import antony.examendaw.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/pacientes")
public class PacienteWebController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AntecedenteRepository antecedenteRepository;

    // Listar todos los pacientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());
        return "paciente/listar";
    }

    // Mostrar formulario de creación
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/crear";
    }

    // Guardar nuevo paciente
    @PostMapping
    public String guardar(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    // Mostrar formulario de edición
    @GetMapping("/actualizar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", pacienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")));
        return "paciente/editar";
    }

    // Actualizar paciente
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    // Desactivar paciente
    @PostMapping("/desactivar/{id}")
    public String desactivar(@PathVariable Long id) {
        Paciente paciente = pacienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente.setActivo(false);
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    // Activar paciente
    @PostMapping("/activar/{id}")
    public String activar(@PathVariable Long id) {
        Paciente paciente = pacienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente.setActivo(true);
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    // Ver detalle del paciente con historia clínica
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        model.addAttribute("paciente", paciente);
        model.addAttribute("nuevoAntecedente", new AntecedenteMedico());
        return "paciente/detalle";
    }

    // Agregar antecedente médico
    @PostMapping("/antecedente/{pacienteId}")
    public String agregarAntecedente(@PathVariable Long pacienteId,
                                     @ModelAttribute AntecedenteMedico antecedente) {
        Paciente paciente = pacienteService.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        
        antecedente.setHistoriaClinica(paciente.getHistoriaClinica());
        antecedente.setFechaRegistro(LocalDate.now());
        antecedenteRepository.save(antecedente);
        
        return "redirect:/pacientes/detalle/" + pacienteId;
    }

    // Eliminar antecedente
    @PostMapping("/antecedente/eliminar/{id}/{pacienteId}")
    public String eliminarAntecedente(@PathVariable Long id, @PathVariable Long pacienteId) {
        antecedenteRepository.deleteById(id);
        return "redirect:/pacientes/detalle/" + pacienteId;
    }
}
