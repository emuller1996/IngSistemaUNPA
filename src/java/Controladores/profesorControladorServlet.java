/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import Modelos.Profesor;
import ModeloDB.ModeloGeneralDAO;
import ModeloDB.ModeloProfesorDAO;


/**
 *
 * @author user
 */
@WebServlet(name = "profesor", urlPatterns = {"/profesor"})
public class profesorControladorServlet extends HttpServlet {


    private ModeloProfesorDAO modelProfe;

    @Resource(name = "jdbc/IngSistemas")

    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        modelProfe = new ModeloProfesorDAO(miPool);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("")) {
            action = "index";
        }

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "new":
                newProfesor(request, response);
                break;
            case "store":
                storeProfesor(request, response);
                break;
            case "editar":
                editarProfesor(request, response);
                break;
            case "update":
                updateDBProfesor(request, response);
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        List<Profesor> listaProfesores = new ArrayList<>();
        try {
            listaProfesores = modelProfe.allProfesores();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("listaProfesores", listaProfesores);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Profesores/index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void newProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Profesores/new.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void storeProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(request.getParameter("profesor_ingreso_reg"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Profesor p = new Profesor(
                request.getParameter("profesor_nombre_reg"),
                fechaDate,
                request.getParameter("profesor_correo_reg"),
                request.getParameter("profesor_titulo_reg"));

        try {
            modelProfe.insertProfesor(p);
        } catch (SQLException ex) {
            Logger.getLogger(profesorControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        index(request, response);

    }

    private void editarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("profesor_id"));

        try {
            Profesor profeEdiar = modelProfe.getProfesor(id);
            request.setAttribute("profesor_edit", profeEdiar);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Profesores/edit.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void updateDBProfesor(HttpServletRequest request, HttpServletResponse response) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(request.getParameter("profesor_ingreso_edit"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Profesor p = new Profesor(
                Integer.parseInt(request.getParameter("profesor_id_edit")),
                request.getParameter("profesor_nombre_edit"),
                fechaDate,
                request.getParameter("profesor_correo_edit"),
                request.getParameter("profesor_titulo_edit"));

        try {
            modelProfe.updateProfesor(p);
            
            index(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(profesorControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(profesorControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
