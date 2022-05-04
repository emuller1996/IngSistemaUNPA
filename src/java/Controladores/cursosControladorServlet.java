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
import Modelos.Curso;
import Modelos.Profesor;
import ModeloDB.ModeloCursoDAO;
import ModeloDB.ModeloGeneralDAO;

@WebServlet(name = "Cursos", urlPatterns = {"/Cursos"})
public class cursosControladorServlet extends HttpServlet {

    private ModeloCursoDAO modelCurso;
    @Resource(name = "jdbc/IngSistemas")

    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        modelCurso = new ModeloCursoDAO(miPool);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "index":
                index(request, response);
                break;
            case "new":
                newCurso(request, response);
                break;
            case "store":
                storeCurso(request, response);
                break;
            case "edit":
                editCurso(request, response);
                break;
            case "delete":
                deleteCurso(request, response);
                break;
            case "update":
                updateCurso(request, response);
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

        List<Curso> listaCursos = new ArrayList<>();
        try {
            listaCursos = listaCursos = modelCurso.allCurso();
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("listaCursoSJP", listaCursos);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Cursos/index.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void newCurso(HttpServletRequest request, HttpServletResponse response) {
        List<Profesor> listaProfesor = null;
        try {
            listaProfesor = modelCurso.allProfesores();
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("listaProfesorJSP", listaProfesor);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Cursos/new.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void storeCurso(HttpServletRequest request, HttpServletResponse response) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateFin = null, fechaDateIncio = null;
        try {

            fechaDateFin = formato.parse(request.getParameter("curso_fin_reg"));
            fechaDateIncio = formato.parse(request.getParameter("curso_inicio_reg"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Curso c = new Curso(
                request.getParameter("curso_nombre_reg"),
                fechaDateIncio,
                fechaDateFin,
                Integer.parseInt(request.getParameter("curso_cantidad_cupos_reg")),
                Integer.parseInt(request.getParameter("curso_duracion_reg")),
                request.getParameter("curso_descripcion_reg"),
                Integer.parseInt(request.getParameter("curso_profesor_reg")));

        try {
            modelCurso.inserCurso(c);
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        index(request, response);

    }

    private void deleteCurso(HttpServletRequest request, HttpServletResponse response) {
        int curso_id = Integer.parseInt(request.getParameter("curso_id"));

        try {
            modelCurso.deleteCurso(curso_id);
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        index(request, response);

    }

    private void editCurso(HttpServletRequest request, HttpServletResponse response) {

        List<Profesor> listaProfesor = null;
        try {
            listaProfesor = modelCurso.allProfesores();
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("listaProfesorJSP", listaProfesor);

        int curso_id = Integer.parseInt(request.getParameter("curso_id"));
        Curso curso_edit = null;
        try {
            curso_edit = modelCurso.getCurso(curso_id);
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("curso_edit_JSP", curso_edit);

        RequestDispatcher miDispatcher;
        miDispatcher = request.getRequestDispatcher("Admin/Cursos/edit.jsp");

        try {
            miDispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void updateCurso(HttpServletRequest request, HttpServletResponse response) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDateFin = null, fechaDateIncio = null;
        try {

            fechaDateFin = formato.parse(request.getParameter("curso_fin_edit"));
            fechaDateIncio = formato.parse(request.getParameter("curso_inicio_edit"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Curso curso_update;

        curso_update = new Curso(
                Integer.parseInt(request.getParameter("curso_id_edit")),
                request.getParameter("curso_nombre_edit"),
                fechaDateIncio,
                fechaDateFin,
                Integer.parseInt(request.getParameter("curso_cantidad_cupos_edit")),
                Integer.parseInt(request.getParameter("curso_duracion_edit")),
                request.getParameter("curso_descripcion_edit"),
                Integer.parseInt(request.getParameter("curso_profesor_edit")));

        try {
            modelCurso.updateCurso(curso_update);
        } catch (SQLException ex) {
            Logger.getLogger(cursosControladorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        index(request, response);

    }

}
