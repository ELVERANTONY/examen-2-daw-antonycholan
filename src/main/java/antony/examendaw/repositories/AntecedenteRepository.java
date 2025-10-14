package antony.examendaw.repositories;

import antony.examendaw.entities.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedenteRepository extends JpaRepository<AntecedenteMedico, Long> {
}
