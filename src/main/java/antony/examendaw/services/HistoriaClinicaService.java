package antony.examendaw.services;

import antony.examendaw.entities.HistoriaClinica;
import antony.examendaw.entities.Paciente;
import antony.examendaw.repositories.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinica crearHistoriaClinica(Paciente paciente) {
        HistoriaClinica historia = new HistoriaClinica();
        historia.setPaciente(paciente);
        historia.setFechaApertura(LocalDate.now());
        historia.setNumeroHistoria(generarNumeroHistoria());
        return historiaClinicaRepository.save(historia);
    }

    private String generarNumeroHistoria() {
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = historiaClinicaRepository.count() + 1;
        return "HC-" + fecha + "-" + String.format("%04d", count);
    }
}
