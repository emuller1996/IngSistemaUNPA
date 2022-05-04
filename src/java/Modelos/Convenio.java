
package Modelos;

import java.io.InputStream;
import java.util.Date;

public class Convenio {
    private int convenio_id;
    private String convenio_titulo;
    private String convenio_descripcion;
    private Date convenio_fecha;
    private String convenio_vigente; 
    private String convenio_origen; 
    private InputStream convenio_pdf;
    private byte[] convenio_pdf2;

    public Convenio(String convenio_titulo, String convenio_descripcion, Date convenio_fecha, String convenio_vigente, String convenio_origen, InputStream convenio_pdf) {
        this.convenio_titulo = convenio_titulo;
        this.convenio_descripcion = convenio_descripcion;
        this.convenio_fecha = convenio_fecha;
        this.convenio_vigente = convenio_vigente;
        this.convenio_origen = convenio_origen;
        this.convenio_pdf = convenio_pdf;
    }

    public Convenio(int convenio_id, String convenio_titulo, String convenio_descripcion, Date convenio_fecha, String convenio_vigente, String convenio_origen) {
        this.convenio_id = convenio_id;
        this.convenio_titulo = convenio_titulo;
        this.convenio_descripcion = convenio_descripcion;
        this.convenio_fecha = convenio_fecha;
        this.convenio_vigente = convenio_vigente;
        this.convenio_origen = convenio_origen;
    }
    
    

    
    

    public int getConvenio_id() {
        return convenio_id;
    }

    public void setConvenio_id(int convenio_id) {
        this.convenio_id = convenio_id;
    }

    public String getConvenio_titulo() {
        return convenio_titulo;
    }

    public void setConvenio_titulo(String convenio_titulo) {
        this.convenio_titulo = convenio_titulo;
    }

    public Date getConvenio_fecha() {
        return convenio_fecha;
    }

    public void setConvenio_fecha(Date convenio_fecha) {
        this.convenio_fecha = convenio_fecha;
    }

    public String getConvenio_vigente() {
        return convenio_vigente;
    }

    public void setConvenio_vigente(String convenio_vigente) {
        this.convenio_vigente = convenio_vigente;
    }

    public String getConvenio_origen() {
        return convenio_origen;
    }

    public void setConvenio_origen(String convenio_origen) {
        this.convenio_origen = convenio_origen;
    }

    public InputStream getConvenio_pdf() {
        return convenio_pdf;
    }

    public void setConvenio_pdf(InputStream convenio_pdf) {
        this.convenio_pdf = convenio_pdf;
    }

    public byte[] getConvenio_pdf2() {
        return convenio_pdf2;
    }

    public void setConvenio_pdf2(byte[] convenio_pdf2) {
        this.convenio_pdf2 = convenio_pdf2;
    }

    public String getConvenio_descripcion() {
        return convenio_descripcion;
    }

    public void setConvenio_descripcion(String convenio_descripcion) {
        this.convenio_descripcion = convenio_descripcion;
    }
    
    

    @Override
    public String toString() {
        return "Convenio{" + "convenio_id=" + convenio_id + ", convenio_titulo=" + convenio_titulo + ", convenio_descripcion=" + convenio_descripcion + ", convenio_fecha=" + convenio_fecha + ", convenio_vigente=" + convenio_vigente + ", convenio_origen=" + convenio_origen + ", convenio_pdf=" + convenio_pdf + ", convenio_pdf2=" + convenio_pdf2 + '}';
    }

    
    
    
    
    
    
    
}
