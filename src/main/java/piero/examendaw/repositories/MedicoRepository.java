package piero.examendaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import piero.examendaw.entities.Medico;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
