package ModeloDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Modelos.Profesor;

public class ModeloProfesorDAO  extends ModeloGeneralDAO{

    DataSource con;

    public ModeloProfesorDAO(DataSource pool) {
        super(pool);
        this.con = pool;
    }

    public void insertProfesor(Profesor p) throws SQLException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("INSERT INTO profesores(`nombreProfesor`, `fechaIngreso`, `correoElectronico`, `tituloAcademico`) VALUES (?,?,?,?)");
        pst.setString(1, p.getNombreProfesor());

        java.util.Date utilDate = p.getFechaIngreso();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
        pst.setDate(2, fechaConvertida);

        pst.setString(3, p.getCorreoElectronico());
        pst.setString(4, p.getTitulAcademico());

        pst.execute();
        con.close();
        pst.close();

    }

    public Profesor getProfesor(int profesor_id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Profesor p = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT * FROM  profesores  WHERE idProfesor = ?");
        pst.setInt(1, profesor_id);

        rs = pst.executeQuery();

        if (rs.next()) {
            p = new Profesor(
                    rs.getInt("idProfesor"),
                    rs.getString("nombreProfesor"),
                    rs.getDate("fechaIngreso"),
                    rs.getString("correoElectronico"),
                    rs.getString("tituloAcademico"));
        }

        con.close();
        pst.close();
        return p;

    }

    public void updateProfesor(Profesor profesor) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        

        pst = con.prepareStatement("UPDATE `profesores` SET  `nombreProfesor` = ?,`fechaIngreso`=?,`correoElectronico`=?,`tituloAcademico`=? WHERE `idProfesor` = ?");
        pst.setString(1, profesor.getNombreProfesor());

        java.util.Date utilDate = profesor.getFechaIngreso();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

        pst.setDate(2, fechaConvertida);
        pst.setString(3,profesor.getCorreoElectronico());
        pst.setString(4, profesor.getTitulAcademico());
        pst.setInt(5, profesor.getIdProfesor());
        
        
        int res = pst.executeUpdate();
        
        if(res==1){
            pst.close();
            con.close();
            System.out.println("Usuario Actualizado"
                    + "muller.edu.com.modelosDB.modeloProfesor.updateProfesor()");
        }else{
            System.err.println("Error al Actualizar");
            
        }
        

    }
}
