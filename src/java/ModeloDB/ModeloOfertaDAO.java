package ModeloDB;

import Modelos.ofertas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


public class ModeloOfertaDAO {

    DataSource con;

    public ModeloOfertaDAO(DataSource pool) {
        this.con = pool;
    }

    public void insertOferta(ofertas o) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("INSERT INTO `ofertas`(`tituloOferta`, `tipoOferta`, `descripcionOferta`, `fechaOferta`, `salarioOferta`, `fechaInicio`, `fechaFin`, `empresaOferta`) VALUES "
                + "(?,?,?,?,?,?,?,?)");
        pst.setString(1, o.getTituloOferta());
        pst.setString(2, o.getTipoOferta());
        pst.setString(3, o.getDescripcionOferta());

        java.util.Date utilDate = o.getFechaOferta();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

        pst.setDate(4, fechaConvertida);

        pst.setDouble(5, o.getSalarioOferta());

        java.util.Date utilDate2 = o.getFechaInicio();
        java.sql.Date fechaConvertida2 = new java.sql.Date(utilDate.getTime());
        pst.setDate(6, fechaConvertida2);

        java.util.Date utilDate3 = o.getFechaFin();
        java.sql.Date fechaConvertida3 = new java.sql.Date(utilDate.getTime());
        pst.setDate(7, fechaConvertida3);

        pst.setString(8, o.getEmpresaOferta());

        pst.execute();
        con.close();
        pst.close();

    }

    public ofertas getOferta(int oferta_id) throws SQLException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ofertas oferta_edit = null;

        con = this.con.getConnection();

        pst = con.prepareStatement("SELECT * FROM ofertas WHERE idOFERTA = ? ");
        pst.setInt(1, oferta_id);

        rs = pst.executeQuery();

        if (rs.next()) {
            oferta_edit = new ofertas(
                    rs.getInt("idOFERTA"),
                    rs.getString("tituloOferta"),
                    rs.getString("tipoOferta"),
                    rs.getString("descripcionOferta"),
                    rs.getDate("fechaOferta"),
                    rs.getDouble("salarioOferta"),
                    rs.getDate("fechaInicio"),
                    rs.getDate("fechaFin"),
                    rs.getString("empresaOferta"));

        }
        con.close();
        pst.close();
        return oferta_edit;
    }

    public void updateOferta(ofertas o) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ofertas oferta_edit = null;

        con = this.con.getConnection();
        
        System.out.println(o.getFechaOferta());
        
        
        
        //paseo fechas
        java.util.Date utilDateOferta = o.getFechaOferta();
        java.util.Date utilDateOfertaInicio = o.getFechaInicio();
        java.util.Date utilDateOfertaFin = o.getFechaFin();
        
        
        java.sql.Date fechaOferta = new java.sql.Date(utilDateOferta.getTime());
        java.sql.Date fechaOfertaInicio = new java.sql.Date(utilDateOfertaInicio.getTime());
        java.sql.Date fechaOfertaFin = new java.sql.Date(utilDateOfertaFin.getTime());
        //paseo fechas
        
        
        pst = con.prepareStatement("UPDATE  ofertas SET tituloOferta=?,tipoOferta=?,descripcionOferta=?,fechaOferta=?,salarioOferta=?,fechaInicio=?,fechaFin=?,empresaOferta=? WHERE idOFERTA = ? ");
        pst.setString(1, o.getTituloOferta());
        pst.setString(2, o.getTipoOferta());
        pst.setString(3, o.getDescripcionOferta());
        pst.setDate(4, fechaOferta);
        pst.setDouble(5, o.getSalarioOferta());     
        pst.setDate(6, fechaOfertaInicio);
        pst.setDate(7, fechaOfertaFin);
        pst.setString(8, o.getEmpresaOferta());
        pst.setInt(9, o.getIdOferta());      
        pst.executeUpdate();
        con.close();
        pst.close();
        
        
        
    }

}
