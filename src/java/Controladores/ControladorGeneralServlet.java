/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import ModeloDB.ModeloGeneralDAO;
import Modelos.Convenio;
import Modelos.Curso;
import Modelos.Evento;
import Modelos.Profesor;
import Modelos.ofertas;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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

/**
 *
 * @author user
 */
@WebServlet(name = "INGSistemas", urlPatterns = {"/INGSistemas"})
public class ControladorGeneralServlet extends HttpServlet {

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

        String accion = request.getParameter("c");

        if (accion == null) {
            accion = "index";
        }

        switch (accion) {
            case "index":
                index(request, response);
                break;
            case "convenios":
                convenios(request, response);
                break;
            case "extencion":
                extencion(request, response);
                break;
            case "egresado":
                egresado(request, response);
                break;
            case "ofertas":
                ofertas(request, response);
                break;
            case "profesores":
                profesores(request, response);
                break;
            case "eventos":
                eventos(request, response);
                break;
            case "libroverde":
                libroverde(request, response);
                break;
            case "ver_pdf_convenios":
                ver_pdfConvenio(request, response);
                break;

            default:
                error404(request, response);
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
        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void profesores(HttpServletRequest request, HttpServletResponse response) {
        List<Profesor> listaProfesores = new ArrayList<>();
        try {
            listaProfesores = modelGeneral.allProfesores();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("listaProfesores", listaProfesores);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("profesores.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void convenios(HttpServletRequest request, HttpServletResponse response) {

        List<Convenio> listaConvenio = new ArrayList<>();

        /**
         * PAGINACION DE CURSOS*
         */
        int pagina;
        int paginasTotal = 2;
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
            registroTotal = modelGeneral.getTotalRegistros("convenios");
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
            listaConvenio = modelGeneral.allConvenio(paginaInicio, paginasTotal);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("listaConvenioJSP", listaConvenio);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("convenios.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void extencion(HttpServletRequest request, HttpServletResponse response) {

        List<Curso> allCursos = null;

        /**
         * PAGINACION DE CURSOS*
         */
        int pagina;
        int paginasTotal = 6;
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
            registroTotal = modelGeneral.getTotalRegistros("cursos");
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

        /**
         * PAGINACION DE CURSOS*
         */
        try {
            allCursos = modelGeneral.allCurso(paginaInicio, paginasTotal);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("paginacion_total", pag_int);
        request.setAttribute("paginacion_actual", pagina);
        request.setAttribute("allCursos", allCursos);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("extencion.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void egresado(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("egresado.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void ofertas(HttpServletRequest request, HttpServletResponse response) {

        List<ofertas> allOferta = null;

        /**
         * PAGINACION DE CURSOS*
         */
        int pagina;
        int paginasTotal = 3;
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
            registroTotal = modelGeneral.getTotalRegistros("ofertas");
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
            allOferta = modelGeneral.allOfertas(paginaInicio, paginasTotal);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("allOfertas", allOferta);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("ofertas.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void error404(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("404.html");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void eventos(HttpServletRequest request, HttpServletResponse response) {

        List<Evento> ListaEventos = new ArrayList<>();

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
            registroTotal = modelGeneral.getTotalRegistros("eventos");
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
            ListaEventos = modelGeneral.allEventos(paginaInicio, paginasTotal);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("ListaEventosJSP", ListaEventos);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("eventos.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void libroverde(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("libroverde.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void ver_pdfConvenio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int convenio_id = Integer.parseInt(request.getParameter("convenio_id"));
        byte[] b = null;
        try {
            b = modelGeneral.getPdfCovenio(convenio_id);
        } catch (SQLException ex) {
            Logger.getLogger(convenioControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            response.getOutputStream().write(datosPDF);
    }

}
