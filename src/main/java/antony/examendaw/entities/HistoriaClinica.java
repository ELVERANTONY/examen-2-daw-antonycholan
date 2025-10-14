package antony.examendaw.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historias_clinicas")
public class HistoriaClinica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String numeroHistoria;
    
    private LocalDate fechaApertura;
    
    @OneToOne
    @JoinColumn(name = "paciente_id", unique = true)
    private Paciente paciente;
    
    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<AntecedenteMedico> antecedentes = new ArrayList<>();
    
    private String observaciones;
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroHistoria() {
        return numeroHistoria;
    }
    
    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }
    
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    
    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public List<AntecedenteMedico> getAntecedentes() {
        return antecedentes;
    }
    
    public void setAntecedentes(List<AntecedenteMedico> antecedentes) {
        this.antecedentes = antecedentes;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
