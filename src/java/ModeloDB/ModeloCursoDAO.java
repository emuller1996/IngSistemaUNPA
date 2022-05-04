/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Modelos.Curso;

/**
 *
 * @author user
 */
public class ModeloCursoDAO extends ModeloGeneralDAO {

    public ModeloCursoDAO(DataSource pool) {
        super(pool);
    }

    public List<Curso> allCurso() throws SQLException {

        List<Curso> allCursos = new ArrayList<>();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM cursos AS c inner join profesores AS p ON c.PROFESORES_idProfesor= p.idProfesor ");

        while (rs.next()) {
            Curso c = new Curso(
                    rs.getInt("idCURSO"),
                    rs.getString("nombreCurso"),
                    rs.getDate("fechaInicio"),
                    rs.getDate("fechaFin"),
                    rs.getInt("cuposDisponibles"),
                    rs.getInt("duracionCurso"),
                    rs.getString("descripcionCurso"),
                    rs.getString("nombreProfesor"));
            allCursos.add(c);
        }
        con.close();
        st.close();
        return allCursos;
    }

    public void inserCurso(Curso c) throws SQLException {

        //Conversion de Fecha
        java.util.Date utilDate2 = c.getFechaInicio();
        java.sql.Date fechaConvertida2 = new java.sql.Date(utilDate2.getTime());
        utilDate2 = c.getFechaFin();
        java.sql.Date fechaConvertida1 = new java.sql.Date(utilDate2.getTime());
        //Conversion de Fecha
        
        //Conexion DB
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = this.con.getConnection();
        pst = con.prepareStatement("INSERT INTO `cursos`(`nombreCurso`, `fechaInicio`, `fechaFin`, `cuposDisponibles`, `duracionCurso`, `descripcionCurso`, `PROFESORES_idProfesor`) VALUES "
                + " (?,?,?,?,?,?,?)");
        pst.setString(1, c.getNombreCurso());
        pst.setDate(2, fechaConvertida2);
        pst.setDate(3, fechaConvertida1);
        pst.setInt(4, c.getCuposDisponibles());
        pst.setInt(5,c.getDuracionCurso());
        pst.setString(6, c.getDescripcionCurso());
        pst.setInt(7, c.getIdProfesor());
        
        pst.execute();
        con.close();
        pst.close();
        
        
    }

    public void deleteCurso(int curso_id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        con = this.con.getConnection();
        
        pst = con.prepareStatement("DELETE FROM `cursos` WHERE `idCURSO` = ? ");
        pst.setInt(1, curso_id);
        pst.execute();
        con.close();
        pst.close();
        
        
        
    }

    public Curso getCurso(int curso_id) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Curso curso = null;
        
        con = this.con.getConnection();
        pst =con.prepareStatement("SELECT * FROM cursos AS c inner join profesores AS p ON c.PROFESORES_idProfesor= p.idProfesor  WHERE c.idCURSO = ?");
        pst.setInt(1, curso_id);
        
        rs = pst.executeQuery();
        
        if(rs.next()){
            curso = new Curso(
                    rs.getInt("idCURSO"),
                    rs.getString("nombreCurso"),
                    rs.getDate("fechaInicio"),
                    rs.getDate("fechaFin"),
                    rs.getInt("cuposDisponibles"),
                    rs.getInt("duracionCurso"),
                    rs.getString("descripcionCurso"),
                    rs.getInt("idProfesor"),
                    rs.getString("nombreProfesor"));
            
            con.close();
            pst.close();
            
            return curso;
            
        }
        
        return curso;
    }
    
    public void updateCurso(Curso curso_update) throws SQLException {
    
        //Conversion de Fecha
        java.util.Date utilDate2 = curso_update.getFechaInicio();
        java.sql.Date fechaConvertida2 = new java.sql.Date(utilDate2.getTime());
        utilDate2 = curso_update.getFechaFin();
        java.sql.Date fechaConvertida1 = new java.sql.Date(utilDate2.getTime());
        //Conversion de Fecha
        
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        con = this.con.getConnection();
        
        pst =con.prepareStatement("UPDATE cursos SET  nombreCurso=?,  fechaInicio=?,  fechaFin=? , cuposDisponibles=?, duracionCurso= ?, descripcionCurso = ? , PROFESORES_idProfesor=? WHERE idCURSO = ?");
        
        pst.setString(1, curso_update.getNombreCurso());
        pst.setDate(2, fechaConvertida2);
        pst.setDate(3, fechaConvertida1);
        pst.setInt(4, curso_update.getCuposDisponibles());
        pst.setInt(5, curso_update.getDuracionCurso());
        pst.setString(6, curso_update.getDescripcionCurso());
        pst.setInt(7, curso_update.getIdProfesor());
        pst.setInt(8, curso_update.getIdCurso());
        
        pst.execute();
        pst.close();
        con.close();
        
        
        
        
    }

}
