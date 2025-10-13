package piero.examendaw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piero.examendaw.entities.Medico;
import piero.examendaw.entities.Especialidad;
import piero.examendaw.repositories.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadService especialidadService;

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    // 🔹 Guardar médico con especialidades
    @Override
    public void guardarConEspecialidades(Medico medico, List<Long> especialidadIds) {
        if (especialidadIds != null && !especialidadIds.isEmpty()) {
            List<Especialidad> especialidades = especialidadService.findAllById(especialidadIds);
            medico.setEspecialidades(especialidades);
        } else {
            medico.setEspecialidades(null);
        }
        medicoRepository.save(medico);
    }

    // 🔹 Actualizar médico con especialidades
    @Override
    public void actualizarConEspecialidades(Medico medico, List<Long> especialidadIds) {
        Optional<Medico> existente = medicoRepository.findById(medico.getId());
        if (existente.isEmpty()) {
            throw new RuntimeException("No se puede actualizar: médico no existe");
        }

        Medico medicoBD = existente.get();
        medicoBD.setNombre(medico.getNombre());
        medicoBD.setApellido(medico.getApellido());
        medicoBD.setColegiatura(medico.getColegiatura());
        medicoBD.setEstado(medico.getEstado());

        if (especialidadIds != null && !especialidadIds.isEmpty()) {
            List<Especialidad> especialidades = especialidadService.findAllById(especialidadIds);
            medicoBD.setEspecialidades(especialidades);
        } else {
            medicoBD.setEspecialidades(null);
        }

        medicoRepository.save(medicoBD);
    }
}
