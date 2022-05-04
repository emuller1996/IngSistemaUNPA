package Modelos;

import java.util.Date;

public class Profesor {
    private int idProfesor;
    private String nombreProfesor;
    private Date fechaIngreso;
    private String correoElectronico;
    private String titulAcademico;

    public Profesor(int idProfesor, String nombreProfesor, Date fechaIngreso, String correoElectronico, String titulAcademico) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.fechaIngreso = fechaIngreso;
        this.correoElectronico = correoElectronico;
        this.titulAcademico = titulAcademico;
    }

    public Profesor(String nombreProfesor, Date fechaIngreso, String correoElectronico, String titulAcademico) {
        this.nombreProfesor = nombreProfesor;
        this.fechaIngreso = fechaIngreso;
        this.correoElectronico = correoElectronico;
        this.titulAcademico = titulAcademico;
    }
    
    

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTitulAcademico() {
        return titulAcademico;
    }

    public void setTitulAcademico(String titulAcademico) {
        this.titulAcademico = titulAcademico;
    }
    
    
    
    
    
}
