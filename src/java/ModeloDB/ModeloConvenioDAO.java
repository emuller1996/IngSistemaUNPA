package ModeloDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Modelos.Convenio;

public class ModeloConvenioDAO extends ModeloGeneralDAO {

    DataSource con;

    public ModeloConvenioDAO(DataSource pool) {
        super(pool);
        this.con = pool;
    }

    public void insert_convenio(Convenio convenio) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        java.util.Date utilDate = convenio.getConvenio_fecha();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

        con = this.con.getConnection();
        pst = con.prepareStatement("INSERT INTO convenios(convenio_titulo, convenio_descripcion, convenio_fecha, convenio_vigente, convenio_origen, convenio_pdf) VALUES (?,?,?,?,?,?)");
        pst.setString(1, convenio.getConvenio_titulo());
        pst.setString(2, convenio.getConvenio_descripcion());
        pst.setDate(3, fechaConvertida);
        pst.setString(4, convenio.getConvenio_vigente());
        pst.setString(5, convenio.getConvenio_origen());
        pst.setBlob(6, convenio.getConvenio_pdf());

        pst.execute();
        con.close();
        pst.close();

    }

    public List<Convenio> all_convenio() throws SQLException {

        List<Convenio> listConvenio = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();

        pst = con.prepareStatement("SELECT * FROM `convenios`");

        rs = pst.executeQuery();

        while (rs.next()) {
            Convenio convenio = new Convenio(
                    rs.getInt("convenio_id"),
                    rs.getString("convenio_titulo"),
                    rs.getString("convenio_descripcion"),
                    rs.getDate("convenio_fecha"),
                    rs.getString("convenio_vigente"),
                    rs.getString("convenio_origen"));

            listConvenio.add(convenio);
        }

        con.close();
        pst.close();
        return listConvenio;

    }

    public byte[] getPdfCovenio(int convenio_id) throws SQLException {

        List<Convenio> listConvenio = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        byte[] b = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT convenio_pdf FROM convenios WHERE convenio_id = ? ");
        pst.setInt(1, convenio_id);
        rs = pst.executeQuery();

        if (rs.next()) {
            b = rs.getBytes("convenio_pdf");

            con.close();
            pst.close();
            return b;
        }

        return null;
    }

    public Convenio getConvenio(int convenio_id) throws SQLException {
        Convenio convenio;

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT * FROM `convenios` WHERE convenio_id = ?");
        pst.setInt(1, convenio_id);

        rs = pst.executeQuery();

        if (rs.next()) {
            convenio = new Convenio(
                    rs.getInt("convenio_id"),
                    rs.getString("convenio_titulo"),
                    rs.getString("convenio_descripcion"),
                    rs.getDate("convenio_fecha"),
                    rs.getString("convenio_vigente"),
                    rs.getString("convenio_origen"));

            con.close();
            pst.close();

            return convenio;
        }
        con.close();
        pst.close();
        return null;

    }

    public void update_convenio_pdf(Convenio convenio_edit) {
        
        
    }
    
    public void update_convenio_no_pdf(Convenio convenio_edit) throws SQLException {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        java.util.Date utilDate = convenio_edit.getConvenio_fecha();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
        
         con = this.con.getConnection();
        pst = con.prepareStatement("UPDATE `convenios` SET `convenio_titulo`=?,`convenio_descripcion`=?,`convenio_fecha`=?,`convenio_vigente`=?,`convenio_origen`=? WHERE `convenio_id` = ?");
        pst.setString(1, convenio_edit.getConvenio_titulo());
        pst.setString(2, convenio_edit.getConvenio_descripcion());
        pst.setDate(3, fechaConvertida);
        pst.setString(4, convenio_edit.getConvenio_vigente());
        pst.setString(5, convenio_edit.getConvenio_origen());
        pst.setInt(6, convenio_edit.getConvenio_id());
        
        int a = pst.executeUpdate();
        
        
        if(a==1){
            System.out.println("muller.edu.com.modelosDB.modeloConvenio.update_convenio_no_pdf()");
        }else{
            System.err.println("muller.edu.com.modelosDB.modeloConvenio.update_convenio_no_pdf()");
        }
        
        con.close();
        pst.close();
        
        
    }

}
