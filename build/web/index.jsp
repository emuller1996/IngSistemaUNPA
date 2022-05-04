<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> - Ingenieria de Sistemas UNPA - </title>

    
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


    
    <!-- About Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px;">
                    <div class="position-relative h-100">
                        <img class="img-fluid position-absolute w-100 h-100" src="img/about.jpg" alt="" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                    <h6 class="section-title bg-white text-start text-primary pe-3">Ingeniería Sistemas - UNPA </h6>
                    
                    <h3> Misión</h3>
                    <p class="mb-4">Formar profesionales integrales, comprometidos con el desarrollo del país y en especial la región pacífica, involucrando responsablemente en los procesos de transformación las tecnologías de la información y la comunicación. </p>
                    
                    <h3> Visión</h3>
                    <p class="mb-4">En el año 2024 el programa será reconocido por la calidad en sus procesos de formación, con estudiantes y docentes involucrados en proyectos enmarcados en el mejoramiento de la calidad de vida especialmente en la región pacifica, haciendo uso racional y oportuno de la tecnología con el objeto de mejorar la eficiencia y competitividad de las organizaciones.  </p>
                    
                    
                    <h3>Información General</h3>
                    <div class="row gy-2 gx-4 mb-4">
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i> Modalidad: Presencial</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Duración 9 Semestres</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Código SNIES 90996</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Registro Calificado 02958 del 22 de febrero de 2018</p>
                        </div>
                        
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->
    
   

        

    <jsp:include page="inc/footer.jsp"></jsp:include>


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <jsp:include page="inc/scripts.jsp"></jsp:include>
</body>

</html>