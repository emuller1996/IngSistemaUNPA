<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestión </title>
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
                    
                    <form class="text-center p-2" action="Oferta" method="POST" >
                    <input type="hidden" name="action" value="update" >
                    <input type="hidden" name="oferta_id_edit" value="${oferta_edit_JSP.idOferta}" >
                    <div class="form-floating mb-3">

                        <input value="${oferta_edit_JSP.tituloOferta}" type="text" name="oferta_titulo_edit" class="form-control" id="floatingInput">
                        <label for="floatingInput">Titulo Oferta</label>
                    </div>
                    <div class="row">
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">
                                <select name="oferta_tipo_edit" class="form-select" aria-label="Default select example">

                                    <option <c:if test="${oferta_edit_JSP.tipoOferta== 'Pasantia'}"> selected=""</c:if> value="PASANTIA">PASANTIA</option>
                                    <option <c:if test="${oferta_edit_JSP.tipoOferta == 'Practica'}"> selected=""</c:if> value="PRACTICA">PRACTICA</option>

                                </select>
                                <label for="floatingInput">Tipo Oferta</label>
                            </div>
                        </div>
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">

                                <input value="${oferta_edit_JSP.fechaOferta}" type="date" name="oferta_fecha_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Fecha Oferta</label>
                            </div>
                        </div>
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">

                                <input value="${oferta_edit_JSP.fechaInicio}" type="date" name="oferta_fecha_inicio_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label  for="floatingInput">Fecha Inicio</label>
                            </div>
                        </div>
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">

                                <input value="${oferta_edit_JSP.fechaFin}"  type="date" name="oferta_fin_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Fecha Fin</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" name="oferta_descripcion_edit" placeholder="Descripcion Aqui" id="floatingTextarea2" style="height: 100px">${oferta_edit_JSP.descripcionOferta}</textarea>
                        <label  for="floatingTextarea2">Descripcion Oferta</label>
                    </div>
                    <div class="row">
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">
                                <input value="${oferta_edit_JSP.salarioOferta}" type="number" name="oferta_salario_oferta_edit" class="form-control" id="floatingInput" placeholder="name@example.com">

                                <label for="floatingInput">Salario Oferta</label>
                            </div>
                        </div>
                        <div class="col-12 col-md-6" >
                            <div class="form-floating mb-3">

                                <input value="${oferta_edit_JSP.empresaOferta}" type="text" name="oferta_empresa_oferta_edit" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Empresa Oferta</label>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <button class="btn btn-success px-4 shadow" type="submit">
                            <i class="fa-solid fa-floppy-disk"></i>
                            Guardar
                        </button>
                    </div>




                </form>
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