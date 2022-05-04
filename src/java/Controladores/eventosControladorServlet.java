/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import Modelos.Evento;
import ModeloDB.ModeloEventoDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author user
 */
@WebServlet(name = "Eventos", urlPatterns = {"/Eventos"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)

public class eventosControladorServlet extends HttpServlet {

    @Resource(name = "jdbc/IngSistemas")
    DataSource miPool;

    ModeloEventoDAO modeloEventoDB;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.modeloEventoDB = new ModeloEventoDAO(miPool);
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

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "new":
                newEvento(request, response);
                break;
            case "store":
                storeEvento(request, response);
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

    private void index(HttpServletRequest request, HttpServletResponse response) {
        
        List<Evento> ListaEventos = new ArrayList<>();
        
        try {
            ListaEventos = modeloEventoDB.allEventos();
        } catch (SQLException ex) {
            Logger.getLogger(eventosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("ListaEventosJSP", ListaEventos);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Eventos/index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void newEvento(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Eventos/new.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void storeEvento(HttpServletRequest request, HttpServletResponse response) {

        Evento e = null;

        //Parseo Fechas 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
        Date fechaDateEvento = null;
        Time timeEvento = null;

        try {
            long ms = formatoHora.parse(request.getParameter("evento_hora_reg")).getTime();
            timeEvento = new Time(ms);
        } catch (ParseException ex) {
            Logger.getLogger(eventosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            fechaDateEvento = formato.parse(request.getParameter("evento_fecha_reg"));

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Parseo Fechas

        try {
            Part fileImage = request.getPart("evento_imagen_reg");

            String nombreImage = fileImage.getSubmittedFileName();

            for (Part part : request.getParts()) {
                part.write("C:\\Users\\user\\Documents\\NetBeansProjects\\elearn\\web\\img\\img_eventos\\" + nombreImage);

            }

            e = new Evento(
                    request.getParameter("evento_nombre_reg"),
                    request.getParameter("evento_lugar_reg"),
                    timeEvento,
                    fechaDateEvento,
                    request.getParameter("evento_cantidad_reg"),
                    request.getParameter("evento_invitado_reg"),
                    "img/img_eventos/" + nombreImage);

            response.getWriter().print(e);
            modeloEventoDB.insertEvento(e);
            newEvento(request, response);

        } catch (IOException ex) {
            Logger.getLogger(eventosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(eventosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(eventosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
