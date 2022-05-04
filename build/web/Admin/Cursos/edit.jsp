<%-- 
    Document   : edit
    Created on : 18/03/2022, 12:27:58 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <jsp:include page="../inc/stilo.jsp"></jsp:include>
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


    <jsp:include page="../inc/sidebaradmin.jsp"></jsp:include>


        <!-- Content Start -->
        <div class="content">
            
            
        <jsp:include page="../inc/navbaradmin.jsp"></jsp:include>


            <!-- Blank Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row h-100 bg-light rounded align-items-center justify-content-center mx-0 p-4">
                    
                    <form action="Cursos" method="post" autocomplete="off">
                        <div class="form-floating mb-3">
                            <input type="hidden" name="action" value="update" >
                            <input type="hidden" name="curso_id_edit" value="${curso_edit_JSP.idCurso}" > 
                            <input name="curso_nombre_edit" value="${curso_edit_JSP.nombreCurso}" type="Text" class="form-control" id="floatingInput" placeholder="s   ">
                        <label for="floatingInput">Nombre Curso</label>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="curso_inicio_edit" type="date" value="${curso_edit_JSP.fechaInicio}" class="form-control" id="floatingInput" placeholder="s ">
                                <label for="floatingInput">Inicio Curso</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="curso_fin_edit" value="${curso_edit_JSP.fechaFin}" type="date"  class="form-control" id="floatingInput" placeholder="s   ">
                                <label for="floatingInput">Fin Curso</label>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="curso_cantidad_cupos_edit" value="${curso_edit_JSP.cuposDisponibles}" type="number" class="form-control" id="floatingInput" placeholder="s   ">
                                <label for="floatingInput">Cantidad Cupos</label>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="curso_duracion_edit" value="${curso_edit_JSP.duracionCurso}" type="number" class="form-control" id="floatingInput" placeholder="s   ">
                                <label for="floatingInput">Duracion Curso (En horas)</label>
                            </div>

                        </div>

                    </div>
                    <div class="form-floating mb-3">
                        <textarea name="curso_descripcion_edit" value="${curso_edit_JSP.descripcionCurso}"  class="form-control " placeholder="Leave a comment here" id="floatingTextarea2" style="height: 150px">${curso_edit_JSP.descripcionCurso}</textarea>
                        <label for="floatingTextarea2">Descripcion Curso</label>
                    </div>
                    <div class="form-floating mb-3">
                        <select name="curso_profesor_edit" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                            <option selected>Seleccione un profesor</option>
                            <c:forEach  var="tempProfesor" items="${listaProfesorJSP}" >
                                <option value="${tempProfesor.idProfesor}"  <c:if test="${curso_edit_JSP.idProfesor == tempProfesor.idProfesor}"> selected=""</c:if>  > ${tempProfesor.idProfesor} -  ${tempProfesor.nombreProfesor}</option>
                            </c:forEach>
                            


                        </select>
                        <label for="floatingSelect">Asignar Profesor</label>
                    </div>
                    <div class="mb-3">
                        <button class="btn btn-success px-4 shadow" type="submit">
                            <i class="fa-solid fa-floppy-disk"></i>
                            Actualizar
                        </button>
                    </div>

                </form>
                </div>
            </div>
            <!-- Blank End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

        <jsp:include page="../inc/scriptsadmin.jsp"></jsp:include>
    </body>
</html>
