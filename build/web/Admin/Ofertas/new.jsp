<%-- 
    Document   : new
    Created on : 17/03/2022, 04:16:54 PM
    Author     : INTEL
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Nueva Oferta</title>
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


                <div class="content">
                <jsp:include page="../inc/navbaradmin.jsp"></jsp:include>


                    <!-- Blank Start -->
                    <div class="container-fluid pt-4 px-4">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Nueva Oferta</h6>
                            
                            


                            <form class="text-center p-2" action="Oferta" method="POST" >
                                <input type="hidden" name="action" value="store" >
                                <div class="form-floating mb-3">

                                    <input type="text" name="oferta_titulo_reg" class="form-control" id="floatingInput" placeholder="s">
                                    <label for="floatingInput">Titulo Oferta</label>
                                </div>
                                <div class="row">
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">
                                            <select name="oferta_tipo_reg" class="form-select" aria-label="Default select example">

                                                <option value="PASANTIA">PASANTIA</option>
                                                <option value="PRACTICA">PRACTICA</option>

                                            </select>
                                            <label for="floatingInput">Tipo Oferta</label>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">

                                            <input type="date" name="oferta_fecha_reg" class="form-control" id="floatingInput" placeholder="name@example.com">
                                            <label for="floatingInput">Fecha Oferta</label>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">

                                            <input type="date" name="oferta_fecha_inicio_reg" class="form-control" id="floatingInput" placeholder="name@example.com">
                                            <label for="floatingInput">Fecha Inicio</label>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">

                                            <input type="date" name="oferta_fin_reg" class="form-control" id="floatingInput" placeholder="name@example.com">
                                            <label for="floatingInput">Fecha Fin</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-floating mb-3">
                                    <textarea class="form-control" name="oferta_descripcion_reg" placeholder="Descripcion Aqui" id="floatingTextarea2" style="height: 100px"></textarea>
                                    <label for="floatingTextarea2">Descripcion Oferta</label>
                                </div>
                                <div class="row">
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">
                                            <input type="number" name="oferta_salario_oferta_reg" class="form-control" id="floatingInput" placeholder="name@example.com">

                                            <label for="floatingInput">Salario Oferta</label>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-6" >
                                        <div class="form-floating mb-3">

                                            <input type="text" name="oferta_empresa_oferta_reg" class="form-control" id="floatingInput" placeholder="name@example.com">
                                            <label for="floatingInput">Empresa Oferta</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <button class="btn btn-success px-4 shadow" type="submit">
                                        <i class="fas fa-save me-2"></i>
                                        Guardar
                                    </button>
                                </div>




                            </form>
                        </div>
                    </div>
                    <!-- Blank End -->
                <jsp:include page="../inc/footer.jsp"></jsp:include>
                </div>

            </div> 

        <jsp:include page="../inc/scriptsadmin.jsp"></jsp:include>
    </body>
</html>
