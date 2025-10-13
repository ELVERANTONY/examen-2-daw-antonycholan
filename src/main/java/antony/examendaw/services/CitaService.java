package antony.examendaw.services;

import antony.examendaw.entities.Cita;
import antony.examendaw.repositories.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerPorId(Long id) {
        return citaRepository.findById(id);
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizar(Long id, Cita datos) {
        return citaRepository.findById(id)
                .map(cita -> {
                    cita.setPaciente(datos.getPaciente());
                    cita.setMedico(datos.getMedico());
                    cita.setFecha(datos.getFecha());
                    cita.setHora(datos.getHora());
                    cita.setMotivo(datos.getMotivo());
                    cita.setEstado(datos.getEstado());
                    return citaRepository.save(cita);
                })
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}
