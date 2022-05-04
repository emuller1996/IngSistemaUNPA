<%-- 
    Document   : index
    Created on : 18/03/2022, 12:04:54 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Extencion (Cursos) </title>
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
                        <div class="row  h-100 bg-light rounded align-items-center justify-content-center mx-0 p-4">

                            <div class="table-responsive">
                                <table id="table_curso" class="table table-hover ">

                                    <c:url var="link_nuevo" value="Cursos">
                                        <c:param  name="action" value="new">

                                        </c:param>
                                    </c:url>
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">NOMBRE</th>
                                            <th scope="col">FECHA INICIO</th>
                                            <th scope="col">CUPOS</th>
                                            <th scope="col">DURACION</th>
                                            <th scope="col">PROFESOR</th>
                                            <th scope="col">
                                                <a href="${link_nuevo}" class="btn bg-dark text-light">
                                                <i class="fas fa-plus-square"></i>   
                                            </a>
                                        </th>

                                    </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach var="tempCursos" items="${listaCursoSJP}">
                                    <tr>
                                        <th scope="row">${tempCursos.idCurso}</th>
                                        <td>${tempCursos.nombreCurso}</td>
                                        <td>${tempCursos.fechaInicio}</td>
                                        <td>${tempCursos.cuposDisponibles}</td>
                                        <td>${tempCursos.duracionCurso}</td>
                                        <td>${tempCursos.nombreProfesor}</td>
                                        <td>
                                    <c:url var="link_borrar" value="Cursos">
                                        <c:param name="action" value="delete"></c:param>
                                        <c:param name="curso_id" value="${tempCursos.idCurso}"></c:param>
                                    </c:url>
                                    <c:url var="link_edit" value="Cursos">
                                        <c:param name="action" value="edit"></c:param>
                                        <c:param name="curso_id" value="${tempCursos.idCurso}"></c:param>
                                    </c:url>
                                    <div class="btn-group">

                                        <a class="btn btn-primary " href="${link_edit}">
                                            <i class="fas fa-edit"></i>
                                        </a>
                                        <a class="borrar_btn btn btn-danger " href="${link_borrar}">
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                    </div>


                                    </td>



                                    </tr> 
                                </c:forEach>



                                </tbody>

                            </table>
                        </div>
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
                                <!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
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
        
        <script>





            $("#table_curso").dataTable({
                "language": {
                    "lengthMenu": "Mostrar _MENU_ Por Pagina",
                    "zeroRecords": "Nada Encontrado",
                    "info": "Mostrando pagina _PAGE_ de _PAGES_ ",
                    "paginate": {
                        "first": "Primero",
                        "last": "Último",
                        "next": "Siguiente",
                        "previous": "Anterior"
                    },
                    "search": "Buscar "

                }
            });
        </script>
    </body>
</html>
