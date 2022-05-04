/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import Modelos.Usuario;
import ModeloDB.ModeloGeneralDAO;

/**
 *
 * @author user
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class loginControladorServlet extends HttpServlet {

    private ModeloGeneralDAO modelGeneral;

    @Resource(name = "jdbc/IngSistemas")

    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        modelGeneral = new ModeloGeneralDAO(miPool);
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

        if(action==null){
            action="login";
        }
        
        switch (action) {
            case "validarUsuario":
                validarUsuario(request, response);
                break;
            case "home":
                home(request, response);
                break;
            case "login":
                loginIn(request, response);
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

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response) {

        Usuario usuario = new Usuario(request.getParameter("usuario_usuario_log"), request.getParameter("usuario_pass_log"));

        boolean estadoValdado = false;
        try {
            estadoValdado = modelGeneral.loginUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(loginControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (estadoValdado == true) {
            RequestDispatcher miDispatcher;
            miDispatcher = request.getRequestDispatcher("Admin/home.jsp");

            try {
                miDispatcher.forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            RequestDispatcher miDispatcher;
            miDispatcher = request.getRequestDispatcher("Admin/login.jsp");

            try {
                miDispatcher.forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/home.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    private void loginIn(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/login.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
