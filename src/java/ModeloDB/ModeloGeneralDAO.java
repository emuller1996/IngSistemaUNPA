/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDB;

import Modelos.Convenio;
import Modelos.Curso;
import Modelos.Evento;
import Modelos.Profesor;
import Modelos.Usuario;
import Modelos.ofertas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author user
 */
public class ModeloGeneralDAO {
    
    DataSource con;

    public ModeloGeneralDAO(DataSource pool) {
        this.con = pool;
    }
    
    public boolean loginUsuario(Usuario usuario) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Boolean estadoValidado = false;

        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT * FROM usuarios WHERE Usuario_usuario = ? AND Usuario_Pass = ? ");
        pst.setString(1, usuario.getUsuario_usuario());
        pst.setString(2, usuario.getUsuario_Pass());
        rs = pst.executeQuery();

        if (rs.next() == true) {
            con.close();
            pst.close();
            System.err.println("USUARIO CORRECTAMENTE VALIDADO");
            return true;
        } else {
            con.close();
            pst.close();
            System.err.println("USUARIO NO SE HA ENCONTRADO EN EL SISTEM");
            return false;
        }

    }
    
    public List<Convenio> allConvenio(int start, int total) throws SQLException {

        List<Convenio> listConvenio = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();

        pst = con.prepareStatement("SELECT * FROM `convenios` LIMIT ?,?");
        pst.setInt(1, start);
        pst.setInt(2, total);
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
    
    public List<Curso> allCurso(int inicio, int total) throws SQLException {

        List<Curso> allCursos = new ArrayList<>();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM cursos AS c inner join profesores AS p ON c.PROFESORES_idProfesor= p.idProfesor LIMIT " + inicio + "," + total + "");

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
    
    public List<ofertas> allOfertas(int inicio, int total) throws SQLException {
        List<ofertas> allOfertas = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM `ofertas` LIMIT " + inicio + "," + total + "");

        while (rs.next()) {
            ofertas o = new ofertas(
                    rs.getInt("idOFERTA"),
                    rs.getString("tituloOferta"),
                    rs.getString("tipoOferta"),
                    rs.getString("descripcionOferta"),
                    rs.getDate("fechaOferta"),
                    rs.getDouble("salarioOferta"),
                    rs.getDate("fechaInicio"),
                    rs.getDate("fechaFin"),
                    rs.getString("empresaOferta"));
            allOfertas.add(o);
        }

        con.close();
        st.close();
        return allOfertas;

    }
    
    public List<Profesor> allProfesores() throws SQLException {
        List<Profesor> listaProfesores = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM `profesores`");

        while (rs.next()) {
            Profesor p = new Profesor(
                    rs.getInt("idProfesor"),
                    rs.getString("nombreProfesor"),
                    rs.getDate("fechaIngreso"),
                    rs.getString("correoElectronico"),
                    rs.getString("tituloAcademico"));

            listaProfesores.add(p);
        }

        con.close();
        st.close();

        return listaProfesores;
    }
    
    
    public int getTotalRegistros(String table) throws SQLException {

        Connection con = null;
        Statement miStatement = null;
        ResultSet miResultset = null;
        int TotalRegistros = 0;

        con = this.con.getConnection();

        miStatement = con.createStatement();
        miResultset = miStatement.executeQuery("SELECT COUNT(*) FROM " + table);
        if (miResultset.next()) {
            TotalRegistros = miResultset.getInt("COUNT(*)");

        }
        con.close();
        miStatement.close();
        return TotalRegistros;

    }
    
    public List<Evento> allEventos(int start, int total) throws SQLException {

        List<Evento> listConvenio = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = this.con.getConnection();
        pst = con.prepareStatement("SELECT * FROM `eventos` LIMIT ?,?");
        pst.setInt(1, start);
        pst.setInt(2, total);
        rs = pst.executeQuery();

        while (rs.next()) {
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
}
