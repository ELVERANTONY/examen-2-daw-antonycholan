package antony.examendaw.services;

import antony.examendaw.entities.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> findAll();
    Optional<Paciente> findById(Long id);
    void save(Paciente paciente);
    void delete(Long id);
}
