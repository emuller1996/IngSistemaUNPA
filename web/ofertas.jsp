<%-- 
    Document   : ofertas
    Created on : 16/03/2022, 10:24:42 PM
    Author     : user
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>- Ofertas -</title>
        <jsp:include page="inc/estilo.jsp"></jsp:include>


        </head>
        <body>

            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Cargando...</span>
                </div>
            </div>




        <jsp:include page="inc/navbar.jsp"></jsp:include>

            <!-- Contenido Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Ofertas </h6>
                        <h3 class="mb-5">Praticas o Pasantias</h3>
                    </div>

                    <div class="">
                        <div class="row">

                        <c:forEach var="oferta" items="${allOfertas}">


                            <div class="col-12 wow fadeInUp" data-wow-delay="0.1s">
                                <div class=" bg-light  rounded-3 shadow p-4 border border-primary   mb-3">
                                    <h4 class="text-center fs-3 fw-bold mb-3">
                                        ${oferta.tituloOferta}
                                    </h4>
                                    <p> ${oferta.descripcionOferta} </p>
                                    <p class="text-center bg-warning w-50 text-uppercase  mx-auto py-1 rounded-pill px-3 text-white fw-bold fs-6">  ${oferta.tipoOferta} </p>
                                    <div class="row text-center mb-3">
                                        <div class="col">
                                            <p>Publicada :  ${oferta.fechaOferta} </p>
                                        </div>
                                        <div class="col">
                                            <p>Salario $<fmt:formatNumber type="number" maxFractionDigits="2" value="${oferta.salarioOferta}" /> </p>
                                        </div>

                                    </div>
                                    <div class="row text-center">
                                        <div class="col">
                                            <p>Inicio : ${oferta.fechaInicio}</p>
                                        </div>
                                        <div class="col">
                                            <p>Fin : ${oferta.fechaFin}</p>
                                        </div>
                                    </div>
                                    <p> Empresa :  ${oferta.empresaOferta}</p>

                                    <div class="text-center">
                                        <a class="btn btn-primary w-50 fw-bold fs-5 rounded-3"> <i class="fas fa-hand-paper me-2"></i> Aplicar</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="text-center my-2">
                        <div class="btn-group ">
                            <c:choose>
                                <c:when test='${paginacion_actual ==1}'>
                                    <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"  aria-current="page"> &laquo; Anterior</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="?c=ofertas&page=${paginacion_actual-1}" class="btn btn-primary text-white fw-bold "  aria-current="page"> &laquo; Anterior</a>
                                </c:otherwise>           
                            </c:choose>

                            <c:forEach var = "i" begin = "1" end = "${paginacion_total}">

                                <a href="?c=ofertas&page=${i}" class="btn btn-outline-primary text-dark fw-bold  <c:if test="${paginacion_actual == i}"> btn-primary </c:if>">${i}</a>
                            </c:forEach>

                            <c:choose>
                                <c:when test='${paginacion_actual ==paginacion_total}'>
                                    <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"> Siguiente &raquo;</a>
                                </c:when>
                                <c:otherwise>

                                    <a href="?c=ofertas&page=${paginacion_actual+1}" class="btn btn-primary text-white fw-bold"> Siguiente &raquo;</a>
                                </c:otherwise>           
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Contenido end -->







        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <jsp:include page="inc/scripts.jsp"></jsp:include>

    </body>
</html>
