package piero.examendaw.dto;

import piero.examendaw.entities.Medico;

public class MedicoEspecialidad {

    private Medico medico;
    private String especialidad;

    public MedicoEspecialidad() {

    }
    public MedicoEspecialidad(Medico medico, String especialidad) {

    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
