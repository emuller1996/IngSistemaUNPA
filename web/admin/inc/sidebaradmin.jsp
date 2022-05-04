<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3">
    
    <c:url var="OfertasIndex" value="Oferta" >
        <c:param name="action" value="index"></c:param>
    </c:url>
    <c:url var="home" value="login" >
        <c:param name="action" value="home"></c:param>
    </c:url>
    <c:url var="profesor" value="profesor" >
        <c:param name="action" value="index"></c:param>
    </c:url>
    <c:url var="Cursos" value="Cursos" >
        <c:param name="action" value="index"></c:param>
    </c:url>
    <c:url var="Convenios" value="Convenios" >
        <c:param name="action" value="index"></c:param>
    </c:url>
    <c:url var="Eventos" value="Eventos" >
        <c:param name="action" value="index"></c:param>
    </c:url>
    
    <nav class="navbar bg-light navbar-light">
        <a href="${home}" class="navbar-brand mx-4 mb-3">
            <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>BackEnd</h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
            <div class="position-relative">
                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
            </div>
            <div class="ms-3">
                <h6 class="mb-0">Jhon Doe</h6>
                <span>Admin</span>
            </div>
        </div>
        <div class="navbar-nav w-100">
            <a href="${home}" class="nav-item nav-link"><i class="fas fa-home me-2"></i>Inicio</a>
            <a href="${profesor}" class="nav-item nav-link"><i class="fas fa-book-reader me-2"></i>Profesores</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-users me-2"></i>Proyeccion Social</a>
                <div class="dropdown-menu bg-transparent border-0">
                    <a href="#" class="dropdown-item"> <i class="fas fa-user-graduate me-2"></i> Egresados</a>
                    <a href="${Cursos}" class="dropdown-item"> <i class="fas fa-university me-2"></i>  Extencion</a>
                    <a href="${OfertasIndex}" class="dropdown-item"> <i class="fas fa-tools me-2"></i> Pasantias y Practicas</a>
                    <a href="${Convenios}" class="dropdown-item"> <i class="fas fa-network-wired me-2"></i> Convenios</a>
                    <a href="${Eventos}" class="dropdown-item"> <i class="fas fa-calendar me-2"></i> Eventos</a>
                </div>
            </div>
            
            
        </div>
    </nav>
</div>
<!-- Sidebar End -->
