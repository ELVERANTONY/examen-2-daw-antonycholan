package piero.examendaw.services;

import piero.examendaw.entities.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoService {
    List<Medico> findAll();
    Optional<Medico> findById(Long id);
    void save(Medico medico);
    void delete(Long id);

    // Métodos con lógica ManyToMany
    void guardarConEspecialidades(Medico medico, List<Long> especialidadIds);
    void actualizarConEspecialidades(Medico medico, List<Long> especialidadIds);
}
