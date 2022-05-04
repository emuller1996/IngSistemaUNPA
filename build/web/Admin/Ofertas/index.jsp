<%-- 
    Document   : index
    Created on : 17/03/2022, 12:24:00 PM
    Author     : INTEL
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Ofertas</title>
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
                        <h4 class="text-center">Gestion Ofertas</h4>
                        <div class="h-100 bg-light rounded p-4">
                            <div class="flex mb-2 p-2">
                            <c:url var="links_nueva_oferta" value="Oferta">
                                <c:param name="action" value="new"></c:param>
                            </c:url>
                            <a   href="${links_nueva_oferta}"class="flex-1 text-start btn btn-dark me-2 py-3">
                                <i class="fas fa-bullhorn me-2"></i>
                                Nueva Oferta
                            </a>
                            <a   href="#"class="flex-1 text-start btn btn-success  py-3">
                                <i class="fas fa-file-medical-alt me-2"></i>
                                Seguimiento.
                            </a>
                        </div>
                        <div class="">
                            <div class="row">
                                <c:forEach var="oferta" items="${allOfertas}">
                                    <div class="col-md-6 mb-2">
                                        <div class="bg-white mx-2 my-2 rounded-3 border shadow-sm p-2 px-4 h-100">
                                            <div class="text-center fs-5 mb-2"> ${oferta.tituloOferta}</div>
                                            <p class="fs-6"> ${oferta.descripcionOferta}</p>
                                            <span class="bg-success px-2 rounded-pill py-1 text-center text-white">${oferta.tipoOferta}</span>
                                            <div class="row mt-2">
                                                <div class="col-md-6 fw-bold">
                                                    Inicio : ${oferta.fechaInicio}
                                                </div>
                                                <div class="col-md-6">
                                                    fin : ${oferta.fechaFin}
                                                </div>
                                                <div class="col-md-6">
                                                    Publicacion : ${oferta.fechaOferta}
                                                </div>
                                                <div class="col-md-6">
                                                    Salario :  $<fmt:formatNumber type="number" maxFractionDigits="2" value="${oferta.salarioOferta}" />
                                                </div>
                                            </div>
                                            <div class="">
                                                Empresa : ${oferta.empresaOferta}
                                            </div>
                                            <div class=" text-center">
                                                <c:url var="linkUpdate" value="Oferta">
                                                    <c:param name="action" value="edit"></c:param>
                                                    <c:param name="oferta_id" value="${oferta.idOferta}"></c:param>
                                                </c:url>
                                                <a href="${linkUpdate}" class="btn btn-warning">
                                                    <i class="fas fa-edit"></i>
                                                    Editar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                            <div class="text-center mt-4">
                                <div class="btn-group ">
                                    <c:choose>
                                        <c:when test='${paginacion_actual ==1}'>
                                            <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"  aria-current="page"> &laquo; Anterior</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="?action=index&page=${paginacion_actual-1}" class="btn btn-primary text-white fw-bold "  aria-current="page"> &laquo; Anterior</a>
                                        </c:otherwise>           
                                    </c:choose>

                                    <c:forEach var = "i" begin = "1" end = "${paginacion_total}">

                                        <a href="?action=index&page=${i}" class="btn btn-outline-primary text-dark fw-bold  <c:if test="${paginacion_actual == i}"> btn-primary </c:if>">${i}</a>
                                    </c:forEach>

                                    <c:choose>
                                        <c:when test='${paginacion_actual ==paginacion_total}'>
                                            <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"> Siguiente &raquo;</a>
                                        </c:when>
                                        <c:otherwise>

                                            <a href="?action=index&page=${paginacion_actual+1}" class="btn btn-primary text-white fw-bold"> Siguiente &raquo;</a>
                                        </c:otherwise>           
                                    </c:choose>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- Blank End -->


                <jsp:include page="../inc/footer.jsp"></jsp:include>
                </div>
                <!-- Content End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            </div>

        <jsp:include page="../inc/scriptsadmin.jsp"></jsp:include>



    </body>
</html>
