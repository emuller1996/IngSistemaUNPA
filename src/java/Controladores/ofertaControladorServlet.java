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
import Modelos.ofertas;
import ModeloDB.ModeloGeneralDAO;
import ModeloDB.ModeloOfertaDAO;


/**
 *
 * @author user
 */
@WebServlet(name = "Oferta", urlPatterns = {"/Oferta"})
public class ofertaControladorServlet extends HttpServlet {

    private ModeloGeneralDAO modeloGeneral;
    private ModeloOfertaDAO modelOferta;

    @Resource(name = "jdbc/IngSistemas")

    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        modeloGeneral = new ModeloGeneralDAO(miPool);
        modelOferta = new ModeloOfertaDAO(miPool);
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
                new_oferta(request, response);
                break;
            case "store":
                store_oferta(request, response);
                break;
            case "edit":
                edit_oferta(request, response);
                break;
            case "update":
                update_oferta(request, response);
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

        List<ofertas> allOferta = null;
        
        
        
        /**
         * PAGINACION DE CURSOS*
         */
        int pagina;
        int paginasTotal = 4;
        int registroTotal = 0;
        int paginaInicio = 0;
        if (request.getParameter("page") == null) {
            pagina = 1;
            paginaInicio = 0;
        } else {
            pagina = Integer.parseInt(request.getParameter("page"));
        }

        if (pagina == 1) {
            paginaInicio = pagina - 1;
        } else {
            System.out.println("muller.edu.com.controladores.generalControlador.cursos()");
            paginaInicio = pagina * paginasTotal - paginasTotal;
        }

        //TOTAL DE REGISTROS
        try {
            registroTotal = modeloGeneral.getTotalRegistros("ofertas");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //TOTAL DE REGISTROS
        double TotalD = paginasTotal;
        double TotalRD = registroTotal;
        double aa = Math.ceil(TotalRD / TotalD);
        int pag_int = (int) aa;

        System.out.println(" Paginacion Actual : " + pagina
                + " Total Registros " + registroTotal
                + "Veces Pages " + pag_int + "  Round " + aa
        );
        request.setAttribute("paginacion_total", pag_int);
        request.setAttribute("paginacion_actual", pagina);
        
        /**
         * PAGINACION DE CURSOS*
         */
        
        
        try {
            allOferta = modeloGeneral.allOfertas(paginaInicio,paginasTotal);
        } catch (SQLException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


        request.setAttribute("allOfertas", allOferta);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Ofertas/index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void new_oferta(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Ofertas/new.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void store_oferta(HttpServletRequest request, HttpServletResponse response) {
        
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateOferta = null,fechaDateFin = null,fechaDateIncio = null;
        try {
            fechaDateOferta = formato.parse(request.getParameter("oferta_fecha_reg"));
            fechaDateFin = formato.parse(request.getParameter("oferta_fin_reg"));
            fechaDateIncio = formato.parse(request.getParameter("oferta_fecha_inicio_reg"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        ofertas oNew = new ofertas(
                request.getParameter("oferta_titulo_reg"),
                request.getParameter("oferta_tipo_reg"),
                request.getParameter("oferta_descripcion_reg"),
                fechaDateOferta,
                Double.parseDouble(request.getParameter("oferta_salario_oferta_reg")),
                fechaDateIncio,
                fechaDateFin,
                request.getParameter("oferta_empresa_oferta_reg"));
        
        
        
        try {
            modelOferta.insertOferta(oNew);
        } catch (SQLException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        index(request, response);
        
        
        
        
    }

    private void edit_oferta(HttpServletRequest request, HttpServletResponse response) {
        
        
        int oferta_id = Integer.parseInt(request.getParameter("oferta_id"));
        ofertas oferta_edit = null;
        
        try {
             oferta_edit = modelOferta.getOferta(oferta_id);
        } catch (SQLException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        request.setAttribute("oferta_edit_JSP", oferta_edit);
        
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("/Admin/Ofertas/edit.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void update_oferta(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateOferta = null,fechaDateFin = null,fechaDateIncio = null;
        ofertas oferta_edit = null;
        try {
            fechaDateOferta = formato.parse(request.getParameter("oferta_fecha_edit"));
            fechaDateFin = formato.parse(request.getParameter("oferta_fin_edit"));
            fechaDateIncio = formato.parse(request.getParameter("oferta_fecha_inicio_edit"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        ofertas oNew = new ofertas(
                Integer.parseInt( request.getParameter("oferta_id_edit")),
                request.getParameter("oferta_titulo_edit"),
                request.getParameter("oferta_tipo_edit"),
                request.getParameter("oferta_descripcion_edit"),
                fechaDateOferta,
                Double.parseDouble(request.getParameter("oferta_salario_oferta_edit")),
                fechaDateIncio,
                fechaDateFin,
                request.getParameter("oferta_empresa_oferta_edit"));
        
        
        try {
            modelOferta.updateOferta(oNew);
        } catch (SQLException ex) {
            Logger.getLogger(ofertaControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        
        
        
        index(request, response);
        
    }

}
