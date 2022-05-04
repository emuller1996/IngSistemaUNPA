<%-- 
    Document   : edit
    Created on : 17/03/2022, 11:50:50 PM
    Author     : user
--%>

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
                        <div class="row h-100 bg-light rounded align-items-center justify-content-center mx-0">
                            <form class="text-center" action="profesor" method="POST" >
                                <div class="text-muted mb-2">
                                    Editar Profesor
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="hidden" name="action" value="update" >
                                    <input type="hidden" name="profesor_id_edit" value="${profesor_edit.idProfesor}" >
                                <input type="text" value="${profesor_edit.nombreProfesor}" name="profesor_nombre_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Nombre Profesor</label>
                            </div>
                            <div class="row">
                                <div class="col-12 col-md-6" >
                                    <div class="form-floating mb-3">
                                        <input type="date" value="${profesor_edit.fechaIngreso}" name="profesor_ingreso_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                        <label for="floatingInput">Fecha Ingreso</label>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6" >
                                    <div class="form-floating mb-3">
                                        <input type="text"  name="profesor_titulo_edit" value="${profesor_edit.titulAcademico}" class="form-control" id="floatingInput" placeholder="name@example.com">
                                        <label for="floatingInput">Titulo Academico</label>
                                    </div>
                                </div>

                            </div>
                            <div class="form-floating mb-3">
                                <input type="email" name="profesor_correo_edit" value="${profesor_edit.correoElectronico}" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Correo electronicio</label>
                            </div>


                            <div class="mb-3">
                                <button class="btn btn-warning px-5">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                    Update
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
