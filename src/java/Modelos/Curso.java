/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author user
 */
public class Curso {
    
    private int idCurso;
    private String nombreCurso;
    private Date fechaInicio; 
    private Date fechaFin;
    private int cuposDisponibles;
    private int duracionCurso;
    private String descripcionCurso;
    private int idProfesor;
    private String nombreProfesor;

    public Curso(int idCurso, String nombreCurso, Date fechaInicio, Date fechaFin, int cuposDisponibles, int duracionCurso, String descripcionCurso, String nombreProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuposDisponibles = cuposDisponibles;
        this.duracionCurso = duracionCurso;
        this.descripcionCurso = descripcionCurso;
        this.nombreProfesor = nombreProfesor;
    }

    public Curso(String nombreCurso, Date fechaInicio, Date fechaFin, int cuposDisponibles, int duracionCurso, String descripcionCurso, int idProfesor) {
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuposDisponibles = cuposDisponibles;
        this.duracionCurso = duracionCurso;
        this.descripcionCurso = descripcionCurso;
        this.idProfesor = idProfesor;
    }

    public Curso(int idCurso, String nombreCurso, Date fechaInicio, Date fechaFin, int cuposDisponibles, int duracionCurso, String descripcionCurso, int idProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuposDisponibles = cuposDisponibles;
        this.duracionCurso = duracionCurso;
        this.descripcionCurso = descripcionCurso;
        this.idProfesor = idProfesor;
    }
    
    

    public Curso(int idCurso, String nombreCurso, Date fechaInicio, Date fechaFin, int cuposDisponibles, int duracionCurso, String descripcionCurso, int idProfesor, String nombreProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuposDisponibles = cuposDisponibles;
        this.duracionCurso = duracionCurso;
        this.descripcionCurso = descripcionCurso;
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
    }

   
    

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public int getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(int duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
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

    @Override
    public String toString() {
        return "{"
                + " Curso : {" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cuposDisponibles=" + cuposDisponibles + ", duracionCurso=" + duracionCurso + ", descripcionCurso=" + descripcionCurso + ", idProfesor=" + idProfesor + ", nombreProfesor=" + nombreProfesor + '}';
    }
    
    
    
    
    
    
    
    
}
