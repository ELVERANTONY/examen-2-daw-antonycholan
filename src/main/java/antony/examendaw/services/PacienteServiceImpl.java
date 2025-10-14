package antony.examendaw.services;

import antony.examendaw.entities.Paciente;
import antony.examendaw.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void save(Paciente paciente) {
        // Si es un nuevo paciente, crear historia clínica automáticamente
        if (paciente.getId() == null) {
            Paciente pacienteGuardado = pacienteRepository.save(paciente);
            historiaClinicaService.crearHistoriaClinica(pacienteGuardado);
        } else {
            pacienteRepository.save(paciente);
        }
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }
}
