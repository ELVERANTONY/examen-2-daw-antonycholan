package piero.examendaw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piero.examendaw.entities.Especialidad;
import piero.examendaw.errors.EspecialidadError;
import piero.examendaw.repositories.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> findById(Long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public List<Especialidad> findAllById(List<Long> ids) {
        // 🔹 Este método usa directamente el método de JpaRepository
        return especialidadRepository.findAllById(ids);
    }

    @Override
    public void save(Especialidad especialidad) {
        if (especialidad.getId() == null) {
            // Crear nueva especialidad
            especialidadRepository.save(especialidad);
        } else {
            // Actualizar existente
            Especialidad existente = especialidadRepository.findById(especialidad.getId())
                    .orElseThrow(() -> new EspecialidadError("Especialidad no encontrada con ID: " + especialidad.getId()));

            existente.setNombre(especialidad.getNombre());
            existente.setDescripcion(especialidad.getDescripcion());

            especialidadRepository.save(existente);
        }
    }

    @Override
    public void delete(Long id) {
        if (!especialidadRepository.existsById(id)) {
            throw new EspecialidadError("No se puede eliminar: Especialidad no encontrada con ID: " + id);
        }
        especialidadRepository.deleteById(id);
    }
}
