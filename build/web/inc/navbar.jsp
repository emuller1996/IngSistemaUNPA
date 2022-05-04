

<!-- Navbar Start -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">

    <c:url var="index" value="INGSistemas">
        <c:param value="index" name="c"></c:param>
    </c:url>
    <c:url var="convenios" value="INGSistemas">
        <c:param value="convenios" name="c"></c:param>
    </c:url>
    <c:url var="extencion" value="INGSistemas">
        <c:param value="extencion" name="c"></c:param>
    </c:url>
    <c:url var="egresado" value="INGSistemas">
        <c:param value="egresado" name="c"></c:param>
    </c:url>
    <c:url var="ofertas" value="INGSistemas">
        <c:param value="ofertas" name="c"></c:param>
    </c:url>
    <c:url var="profesores" value="INGSistemas">
        <c:param value="profesores" name="c"></c:param>
    </c:url>
    <c:url var="eventos" value="INGSistemas">
        <c:param value="eventos" name="c"></c:param>
    </c:url>
    
    <c:url var="libroverde" value="INGSistemas">
        <c:param value="libroverde" name="c"></c:param>
    </c:url>
    
    <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
        <img src="img/LOGO.png" class="img-logo-unipacifico" />
    </a>
    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        
        <div class="navbar-nav ms-auto p-4 p-lg-0">
            <a href="${index}" class="nav-item nav-link active"> <i class="fas fa-home me-2"></i> Inicio</a>
            <a href="${profesores}" class="nav-item nav-link"> <i class="fas fa-book-reader me-2"></i> Profesores</a>          
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"> <i class="fas fa-users me-2"></i> Proyeccíon Social</a>
                <div class="dropdown-menu fade-down m-0">
                    <a href="${egresado}" class="dropdown-item"> <i class="fas fa-user-graduate me-2"></i> Egresados</a>
                    <a href="${extencion}" class="dropdown-item"> <i class="fas fa-university me-2"></i> Extención</a>
                    <a href="${ofertas}" class="dropdown-item"> <i class="fas fa-tools me-2"></i> Pasantias y Practicas.</a>
                    <a href="${convenios}" class="dropdown-item"> <i class="fas fa-network-wired me-2"></i> Convenios.</a>
                    <a href="${eventos}" class="dropdown-item"> <i class="fas fa-calendar me-2"></i> Eventos.</a>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"> <i class="fas fa-book me-2"></i> Documentos</a>
                <div class="dropdown-menu fade-down m-0">
                    <a href="#" class="dropdown-item">Libro Amarillo.</a>
                    <a href="${libroverde}" class="dropdown-item">Libro Verde.</a>

                </div>
            </div>

        </div>
        <a href="login" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Ingresa Aquí<i class="fa fa-arrow-right ms-3"></i></a>
    </div>
</nav>
<!-- Navbar End -->
