
package Modelos;

import java.util.Date;

/**
 *
 * @author Estefano Muller
 */
public class ofertas {
    
    private int idOferta;
    private String tituloOferta;
    private String tipoOferta;
    private String descripcionOferta;
    private Date fechaOferta;
    private double salarioOferta;
    private Date fechaInicio;
    private Date fechaFin;
    private String empresaOferta;

    public ofertas(int idOferta, String tituloOferta, String tipoOferta, String descripcionOferta, Date fechaOferta, double salarioOferta, Date fechaInicio, Date fechaFin, String empresaOferta) {
        this.idOferta = idOferta;
        this.tituloOferta = tituloOferta;
        this.tipoOferta = tipoOferta;
        this.descripcionOferta = descripcionOferta;
        this.fechaOferta = fechaOferta;
        this.salarioOferta = salarioOferta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresaOferta = empresaOferta;
    }

    public ofertas(String tituloOferta, String tipoOferta, String descripcionOferta, Date fechaOferta, double salarioOferta, Date fechaInicio, Date fechaFin, String empresaOferta) {
        this.tituloOferta = tituloOferta;
        this.tipoOferta = tipoOferta;
        this.descripcionOferta = descripcionOferta;
        this.fechaOferta = fechaOferta;
        this.salarioOferta = salarioOferta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresaOferta = empresaOferta;
    }

    
    
    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getTituloOferta() {
        return tituloOferta;
    }

    public void setTituloOferta(String tituloOferta) {
        this.tituloOferta = tituloOferta;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public Date getFechaOferta() {
        return fechaOferta;
    }

    public void setFechaOferta(Date fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public double getSalarioOferta() {
        return salarioOferta;
    }

    public void setSalarioOferta(double salarioOferta) {
        this.salarioOferta = salarioOferta;
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

    public String getEmpresaOferta() {
        return empresaOferta;
    }

    public void setEmpresaOferta(String empresaOferta) {
        this.empresaOferta = empresaOferta;
    }

    @Override
    public String toString() {
        return "ofertas{" + "idOferta=" + idOferta + ", tituloOferta=" + tituloOferta + ", tipoOferta=" + tipoOferta + ", descripcionOferta=" + descripcionOferta + ", fechaOferta=" + fechaOferta + ", salarioOferta=" + salarioOferta + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", empresaOferta=" + empresaOferta + '}';
    }
    
    
    
    
}
