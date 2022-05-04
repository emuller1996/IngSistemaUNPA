/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import Modelos.Convenio;
import ModeloDB.ModeloConvenioDAO;

/**
 *
 * @author user
 */
@WebServlet(name = "Convenios", urlPatterns = {"/Convenios"})
@MultipartConfig(maxFileSize = 16177215)
public class convenioControladorServlet extends HttpServlet {

    ModeloConvenioDAO convenioModeloDB;
    String actionControlller;
    @Resource(name = "jdbc/IngSistemas")
    DataSource miPool;

    @Override
    public void init() throws ServletException {
        convenioModeloDB = new ModeloConvenioDAO(miPool);
        actionControlller = "index";

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        this.actionControlller = action;
        switch (this.actionControlller) {
            case "index":
                index(request, response);
                break;
            case "new":
                newConvenio(request, response);
                break;
            case "store":
                storeConvenio(request, response);
                break;
            case "ver_pdf":
                ver_pdfConvenio(request, response);
                break;
            case "edit":
                editConvenio(request, response);
                break;
            case "update":
                updateConvenio(request, response);
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

    private void index(HttpServletRequest request, HttpServletResponse response)  {
        
        List<Convenio> listaConvenio = new ArrayList<>();
        
        try {
            listaConvenio = convenioModeloDB.all_convenio();
        } catch (SQLException ex) {
            Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("listaConvenioJSP", listaConvenio);
        
        

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Convenios/index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void newConvenio(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Convenios/new.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void storeConvenio(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Convenio convenio_new;
        InputStream inputStream = null;

        //Parseo Fechas 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateConvenio = null;
        try {

            fechaDateConvenio = formato.parse(request.getParameter("convenio_fecha_reg"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Parseo Fechas

        //Obtener PDF
        try {
            Part filePart = request.getPart("curso_pdf_reg");
            if (filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
            }
        } catch (Exception ex) {
            System.out.println("fichero: " + ex.getMessage());
        }
        //Obtener PDF

        if (inputStream != null) {
            //Maping Objeto
            convenio_new = new Convenio(
                    request.getParameter("convenio_nombre_reg"),
                    request.getParameter("convenio_descripcion_reg"),
                    fechaDateConvenio,
                    request.getParameter("convenio_vigente_reg"),
                    request.getParameter("convenio_origen_reg"),
                    inputStream);
            //Maping Objeto
            try {
                convenioModeloDB.insert_convenio(convenio_new);
            } catch (SQLException ex) {
                Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

           
            
            index(request, response);
            

        } else {
            RequestDispatcher miDispatcher;
            miDispatcher = request.getRequestDispatcher("Admin/Convenios/new.jsp");

            try {
                miDispatcher.forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    private void ver_pdfConvenio(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        int convenio_id = Integer.parseInt(request.getParameter("convenio_id"));
        byte[] b = null;
        try {
            b = convenioModeloDB.getPdfCovenio(convenio_id);
        } catch (SQLException ex) {
            Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            response.getOutputStream().write(datosPDF);    
    }

    private void editConvenio(HttpServletRequest request, HttpServletResponse response) {
        
        int convenio_id = Integer.parseInt(request.getParameter("convenio_id"));
        Convenio convenio_edit = null;
        try {
            convenio_edit= convenioModeloDB.getConvenio(convenio_id);
        } catch (SQLException ex) {
            Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("convenio_editJSP", convenio_edit);
        
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Convenios/edit.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    private void updateConvenio(HttpServletRequest request, HttpServletResponse response) {
        Convenio convenio_edit;
        InputStream inputStream = null;

        //Parseo Fechas 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateConvenio = null;
        try {

            fechaDateConvenio = formato.parse(request.getParameter("convenio_fecha_edit"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Parseo Fechas

        //Obtener PDF
        try {
            Part filePart = request.getPart("curso_pdf_edit");
            if (filePart.getSize() > 0) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
            }
        } catch (Exception ex) {
            System.out.println("fichero: " + ex.getMessage());
        }
        //Obtener PDF
        
        
        if (inputStream != null) {
            //Maping Objeto
            convenio_edit = new Convenio(
                    request.getParameter("convenio_nombre_edit"),
                    request.getParameter("convenio_descripcion_edit"),
                    fechaDateConvenio,
                    request.getParameter("convenio_vigente_edit"),
                    request.getParameter("convenio_origen_edit"),
                    inputStream);
            //Maping Objeto
            

           
            
            index(request, response);
            
            } else {
            
            convenio_edit = new Convenio(
                    Integer.parseInt(request.getParameter("convenio_id_edit")), 
                    request.getParameter("convenio_nombre_edit"),
                    request.getParameter("convenio_descripcion_edit"),
                    fechaDateConvenio,
                    request.getParameter("convenio_vigente_edit"),
                    request.getParameter("convenio_origen_edit"));
            
            try {
                convenioModeloDB.update_convenio_no_pdf(convenio_edit);
                
                index(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    

}
