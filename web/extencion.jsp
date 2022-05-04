<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title> - Extencion -   </title>
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




            <!-- Courses Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Extención (Formacion Continúa) </h6>
                        <h1 class="mb-5">Cursos, Talleres y Diplomados </h1>
                    </div>
                    <div class="row g-4 justify-content-center">


                    <c:forEach var="Curso" items="${allCursos}">

                        <div class="col-lg-4 col-md-6 wow fadeInUp h-100" data-wow-delay="0.1s">
                            <div class="course-item bg-light">
                                <div class="position-relative overflow-hidden">
                                    <img class="img-fluid" src="img/course-1.jpg" alt="">
                                    <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Ver Mas</a>
                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-danger px-3" style="border-radius: 0 30px 30px 0;">Matricularse</a>
                                    </div>
                                </div>
                                <div class="text-center p-4 pb-0">
                                    <h3 class="mb-0">${Curso.nombreCurso}</h3>

                                    <p class="mb-4">${Curso.descripcionCurso}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p> Fecha Inicio ${Curso.fechaInicio} </p>
                                        </div>
                                        <div class="col">
                                            <p> Fecha fin ${Curso.fechaFin}</p>
                                        </div>

                                    </div>

                                </div>
                                <div class="d-flex border-top">
                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>${Curso.nombreProfesor}</small>
                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>${Curso.duracionCurso} Hrs.</small>
                                    <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>${Curso.cuposDisponibles} Cupos</small>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                    <hr>
                <div class="text-center my-2">
                    <div class="btn-group ">
                        <c:choose>
                            <c:when test='${paginacion_actual ==1}'>
                                <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"  aria-current="page"> &laquo; Anterior</a>
                            </c:when>
                            <c:otherwise>
                                <a href="?c=extencion&page=${paginacion_actual-1}" class="btn btn-primary text-white fw-bold"  aria-current="page"> &laquo; Anterior</a>
                            </c:otherwise>           
                        </c:choose>

                        <c:forEach var = "i" begin = "1" end = "${paginacion_total}">

                            <a href="?c=extencion&page=${i}" class="btn btn-outline-primary text-dark fw-bold  <c:if test="${paginacion_actual == i}"> btn-primary </c:if>">${i}</a>
                        </c:forEach>

                        <c:choose>
                            <c:when test='${paginacion_actual ==paginacion_total}'>
                                <a href="#" class="btn btn-outline-primary text-dark fw-bold disabled"> Siguiente &raquo;</a>
                            </c:when>
                            <c:otherwise>

                                <a href="?c=extencion&page=${paginacion_actual+1}" class="btn btn-primary text-white fw-bold"> Siguiente &raquo;</a>
                            </c:otherwise>           
                        </c:choose>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- Courses End -->





<jsp:include page="inc/footer.jsp"></jsp:include>


<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>

</html>