package antony.examendaw.services;

import antony.examendaw.entities.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadService {
    List<Especialidad> findAll();
    Optional<Especialidad> findById(Long id);
    List<Especialidad> findAllById(List<Long> ids);
    void save(Especialidad especialidad);
    void delete(Long id);
}
