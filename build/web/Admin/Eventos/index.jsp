<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url var="links_nueva_oferta" value="Eventos">
    <c:param name="action" value="new"></c:param>
</c:url>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Gestión Eventos </title>
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
                            <div class="flex  p-2">
                                <a   href="${links_nueva_oferta}"class="flex-1 text-start btn btn-dark me-2 py-3">
                                <i class="fas fa-bullhorn me-2"></i>
                                Nuevo Eventos
                                </a>
                                
                            </div>
                        <div class="row p-0 mt-0 g-3">

                            <c:forEach var="evento" items="${ListaEventosJSP}">
                                <div class="col-sm-12 col-md-6 ">
                                    <div class="bg-white p-3 h-100 shadow-sm">
                                        <img class="img-fluid mb-4" src="${evento.evento_imagen_url}">
                                        <div class="row">
                                            <div class="col-12 ">
                                                <h3>${evento.evento_nombre}</h3>
                                            </div>
                                            <div class="col-12 col-md-6">
                                                Lugar : ${evento.evento_lugar}
                                            </div>
                                            <div class="col-12 col-md-6">
                                                Cantidad : ${evento.evento_cantidad}
                                            </div>
                                            <div class="col-12 col-md-6">
                                                Fecha : ${evento.evento_fecha}
                                            </div>
                                            <div class="col-12 col-md-6">
                                                Hora : ${evento.evento_hora}
                                            </div>
                                            <div class="col-12 ">
                                                Invitado : ${evento.evento_invitado}
                                            </div>

                                        </div>



                                    </div>
                                </div>
                            </c:forEach>



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