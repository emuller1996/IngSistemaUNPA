
package Modelos;

import java.sql.Time;
import java.util.Date;

public class Evento {
    
    private int evento_id;
    private String evento_nombre;
    private String evento_lugar;
    private Time evento_hora;
    private Date evento_fecha;
    private String evento_cantidad;
    private String evento_invitado;
    private String evento_imagen_url;

    public Evento(String evento_nombre, String evento_lugar, Time evento_hora, Date evento_fecha, String evento_cantidad, String evento_invitado, String evento_imagen_url) {
        this.evento_nombre = evento_nombre;
        this.evento_lugar = evento_lugar;
        this.evento_hora = evento_hora;
        this.evento_fecha = evento_fecha;
        this.evento_cantidad = evento_cantidad;
        this.evento_invitado = evento_invitado;
        this.evento_imagen_url = evento_imagen_url;
    }

    public int getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
    }

    public String getEvento_nombre() {
        return evento_nombre;
    }

    public void setEvento_nombre(String evento_nombre) {
        this.evento_nombre = evento_nombre;
    }

    public String getEvento_lugar() {
        return evento_lugar;
    }

    public void setEvento_lugar(String evento_lugar) {
        this.evento_lugar = evento_lugar;
    }

    public Time getEvento_hora() {
        return evento_hora;
    }

    public void setEvento_hora(Time evento_hora) {
        this.evento_hora = evento_hora;
    }

    public Date getEvento_fecha() {
        return evento_fecha;
    }

    public void setEvento_fecha(Date evento_fecha) {
        this.evento_fecha = evento_fecha;
    }

    public String getEvento_cantidad() {
        return evento_cantidad;
    }

    public void setEvento_cantidad(String evento_cantidad) {
        this.evento_cantidad = evento_cantidad;
    }

    public String getEvento_invitado() {
        return evento_invitado;
    }

    public void setEvento_invitado(String evento_invitado) {
        this.evento_invitado = evento_invitado;
    }

    public String getEvento_imagen_url() {
        return evento_imagen_url;
    }

    public void setEvento_imagen_url(String evento_imagen_url) {
        this.evento_imagen_url = evento_imagen_url;
    }

    @Override
    public String toString() {
        return "Evento{" + "evento_id=" + evento_id + ", evento_nombre=" + evento_nombre + ", evento_lugar=" + evento_lugar + ", evento_hora=" + evento_hora + ", evento_fecha=" + evento_fecha + ", evento_cantidad=" + evento_cantidad + ", evento_invitado=" + evento_invitado + ", evento_imagen_url=" + evento_imagen_url + '}';
    }
    
    
    
    
}
