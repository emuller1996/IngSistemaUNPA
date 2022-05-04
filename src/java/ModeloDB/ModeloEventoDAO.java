
package ModeloDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import Modelos.Evento;

public class ModeloEventoDAO {
    
    DataSource con;

    public ModeloEventoDAO(DataSource con) {
        this.con = con;
    }
    
    
    public void insertEvento(Evento evento) throws SQLException{
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        java.util.Date utilDate = evento.getEvento_fecha();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
        
        
        con = this.con.getConnection();
        pst = con.prepareStatement("INSERT INTO `eventos`( `evento_nombre`, `evento_lugar`, `evento_hora`, `evento_fecha`, `evento_cantidad`, `evento_invitado`, `evento_imagen_url`) VALUES "
                + " (?,?,?,?,?,?,?)");
        pst.setString(1, evento.getEvento_nombre());
        pst.setString(2, evento.getEvento_lugar());
        pst.setTime(3, evento.getEvento_hora());
        pst.setDate(4, fechaConvertida);
        pst.setString(5, evento.getEvento_cantidad());
        pst.setString(6, evento.getEvento_invitado());
        pst.setString(7, evento.getEvento_imagen_url());
        
        int c = pst.executeUpdate();
        
        if(c==1){
            System.out.println("muller.edu.com.modelosDB.modeloEvento.insertEvento()");
        }else{
            System.err.println("ERROR AL INSERTAR EVENTO");
        }
        
        
       con.close();
       pst.close();
        
        
        
    }

    public List<Evento> allEventos() throws SQLException {
        
        
        List<Evento> listConvenio = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT * FROM `eventos`");
        
        rs = pst.executeQuery();
        
        while(rs.next()){
            Evento e = new Evento(
                    rs.getString("evento_nombre"), 
                    rs.getString("evento_lugar"), 
                    rs.getTime("evento_hora"), 
                    rs.getDate("evento_fecha"), 
                    rs.getString("evento_cantidad"), 
                    rs.getString("evento_invitado"), 
                    rs.getString("evento_imagen_url"));
            
            
            listConvenio.add(e);
        }
        
        pst.close();
        rs.close();
        con.close();
        
        return listConvenio;
        
    }
    
    
    
}
