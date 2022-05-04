<%-- 
    Document   : convenios
    Created on : 16/03/2022, 07:08:17 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> - Covenios -  </title>
        <jsp:include page="inc/estilo.jsp"></jsp:include>


        </head>
        <body>

            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->



        <jsp:include page="inc/navbar.jsp"></jsp:include>



            <!-- Contenido Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Convenios </h6>
                        <h3 class="mb-5">Listado</h3>
                    </div>


                <c:forEach var="convenio" items="${listaConvenioJSP}">
                    <div class="row bg-light rounded-3 border-primary shadow p-4 mb-5">
                        <div class="col-md-4 d-flex align-items-center">
                            <a class="align-self-center" href="#">
                                <img class="img-fluid rounded mb-3 mb-md-0 " src="img/oracle.jpg" alt="">
                            </a>
                        </div>
                        <div class="col-md-8">
                            <h3> ${convenio.convenio_titulo} </h3>
                            <p> ${convenio.convenio_descripcion} </p>
                            <p class="fw-bold d-inline-flex rounded-pill bg-warning p-2 px-3"> ${convenio.convenio_origen} </p>
                            <div class="row">
                                <div class="col text-secondary"> <div class="d-inline-flex rounded-pill bg-success text-white px-4 py-1"> ${convenio.convenio_vigente} </div></div>
                                <div class="col text-secondary">Fecha Inicio  ${convenio.convenio_fecha} </div> 
                            </div>  

                            <c:url var="link_pdf_convenio" value="INGSistemas">
                                <c:param name="c" value="ver_pdf_convenios"></c:param>
                                <c:param name="convenio_id" value="${convenio.convenio_id}"></c:param>

                            </c:url>
                            <a class="btn btn-info fw-bold text-uppercase d-flex justify-content-center  mx-auto w-50" href="${link_pdf_convenio}">Mas Informacion</a>
                        </div>
                    </div>
                </c:forEach>
                <hr>


                <div class="text-center my-2">
                    <div class="btn-group ">
                        <c:choose>
                            <c:when test='${paginacion_actual ==1}'>
                                <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"  aria-current="page"> &laquo; Anterior</a>
                            </c:when>
                            <c:otherwise>
                                <a href="?c=convenios&page=${paginacion_actual-1}" class="btn btn-primary text-white fw-bold"  aria-current="page"> &laquo; Anterior</a>
                            </c:otherwise>           
                        </c:choose>

                        <c:forEach var = "i" begin = "1" end = "${paginacion_total}">

                            <a href="?c=convenios&page=${i}" class="btn btn-outline-primary text-dark fw-bold  <c:if test="${paginacion_actual == i}"> btn-primary </c:if>">${i}</a>
                        </c:forEach>

                        <c:choose>
                            <c:when test='${paginacion_actual ==paginacion_total}'>
                                <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"> Siguiente &raquo;</a>
                            </c:when>
                            <c:otherwise>

                                <a href="?c=convenios&page=${paginacion_actual+1}" class="btn btn-primary text-white fw-bold"> Siguiente &raquo;</a>
                            </c:otherwise>           
                        </c:choose>
                    </div>
                </div>











            </div>
        </div>
        <!-- Contenido End -->





        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <jsp:include page="inc/scripts.jsp"></jsp:include>

    </body>
</html>
