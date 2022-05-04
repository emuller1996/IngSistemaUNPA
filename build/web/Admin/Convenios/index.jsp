<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Gestion de Convenios</title>
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
                        <div class="row  bg-light rounded align-items-center justify-content-center mx-0 p-4">
                            
                        <div class="table-responsive">
                            <table class="table table-hover table-striped ">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">TITULO</th>
                                        <th scope="col">FECHA</th>
                                        <th scope="col">VIGENTE</th>
                                        <th scope="col">ORIGEN</th>
                                        <th scope="col">
                                            <a href="Convenios?action=new" class="btn btn-dark px-4">
                                                <i class="fas fa-plus-square"></i>

                                            </a>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="Convenio" items="${listaConvenioJSP}">
                                        <tr>
                                            <th scope="row">${Convenio.convenio_id}</th>
                                            <td>${Convenio.convenio_titulo}</td>
                                            <td>${Convenio.convenio_fecha}</td>
                                            <td>${Convenio.convenio_vigente}</td>
                                            <td>${Convenio.convenio_origen}</td>
                                            <td width="10px" class="text-center" >
                                                <c:url var="ver_pdf" value="Convenios">
                                                    <c:param name="action" value="ver_pdf" ></c:param>
                                                    <c:param name="convenio_id" value="${Convenio.convenio_id}" ></c:param>
                                                </c:url>
                                                <a href="${ver_pdf}" class="btn btn-success">
                                                    <i class="fas fa-file-pdf"></i>
                                                </a>
                                            </td>
                                            <td >
                                                <div class="btn-group" role="group" aria-label="Basic example">

                                                    <c:url var="edit" value="Convenios">
                                                        <c:param name="action" value="edit" ></c:param>
                                                        <c:param name="convenio_id" value="${Convenio.convenio_id}" ></c:param>
                                                    </c:url>
                                                    <a href="${edit}" class="btn btn-warning">
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
                <!-- Blank End -->


                <!-- Footer Start -->
                <jsp:include page="../inc/footer.jsp"></jsp:include>
                    <!-- Footer End -->
                </div>
                <!-- Content End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            </div>

        <jsp:include page="../inc/scriptsadmin.jsp"></jsp:include>
    </body>

</html>