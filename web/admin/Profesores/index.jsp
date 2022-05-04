<%-- 
    Document   : index
    Created on : 17/03/2022, 11:08:39 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Profesores</title>
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

                    <div class="container-fluid pt-4 px-4">
                        <div class="row h-100 bg-light rounded align-items-center justify-content-center mx-0 p-4">
                            <div class="table-responsive">
                                <table id="table_profesores" class="table  table-hover ">
                                    <thead>

                                    <c:url var="newTe" value="profesor">
                                        <c:param name="action" value="new"></c:param>
                                    </c:url>
                                    <c:url var="editar" value="profesor">
                                        <c:param name="action" value="editar"></c:param>
                                        <c:param name="profesor_id" value="${profesor_edit.idProfesor}"></c:param>
                                    </c:url>    
                                    <tr>
                                        <th scope="col" class="text-uppercase">id</th>
                                        <th scope="col" class="text-uppercase">Nombre</th>
                                        <th scope="col" class="text-uppercase">fecha Ingreso</th>
                                        <th scope="col" class="text-uppercase">Correo</th>
                                        <th scope="col" class="text-uppercase">Titulo Academico</th>
                                        <th scope="col" >
                                            <a href="${newTe}" class="btn btn-success ">
                                                <i class="fas fa-plus-square"></i>                                                
                                            </a>
                                        </th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="tempProfesores" items="${listaProfesores}">

                                        <c:url var="editar" value="profesor">
                                            <c:param name="action" value="editar"></c:param>
                                            <c:param name="profesor_id" value="${tempProfesores.idProfesor}"></c:param>
                                        </c:url>  
                                        <tr>
                                            <th scope="row">${tempProfesores.idProfesor}</th>
                                            <td>${tempProfesores.nombreProfesor}</td>
                                            <td>${tempProfesores.fechaIngreso}</td>
                                            <td>${tempProfesores.correoElectronico}</td>
                                            <td>${tempProfesores.titulAcademico}</td>
                                            
                                            <td>
                                                <div class="btn-group" role="group" aria-label="Basic example">

                                                    
                                                    <a href="${editar}" class="btn btn-warning">
                                                        <i class="fas fa-edit"></i>

                                                    </a>
                                                    <a class="btn btn-danger">
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

                <jsp:include page="../inc/footer.jsp" ></jsp:include>
                </div>
            </div>



        <jsp:include page="../inc/scriptsadmin.jsp"></jsp:include>

        

        <script>


            $('#table_profesores').dataTable({
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
