<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
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
                    
                    <form action="Convenios" method="post" enctype="multipart/form-data" >
                    <div class="form-floating mb-3">
                        <input type="hidden" name="action" value="update" >                                
                        <input type="hidden" name="convenio_id_edit" value="${convenio_editJSP.convenio_id}" >                                
                        <input name="convenio_nombre_edit" value="${convenio_editJSP.convenio_titulo}" type="Text" class="form-control" id="floatingInput" placeholder="s   ">
                        <label for="floatingInput">Titulo Convenio</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea name="convenio_descripcion_edit"  class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"> ${convenio_editJSP.convenio_descripcion}</textarea>
                        <label for="floatingTextarea2">Descripcion Convenio</label>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="convenio_fecha_edit" value="${convenio_editJSP.convenio_fecha}" type="date" class="form-control" id="floatingInput" placeholder="s   ">
                                <label for="floatingInput">Inicio Convenio</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">

                                <select name="convenio_origen_edit" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                    <option value="LOCAL" <c:if test="${convenio_editJSP.convenio_origen == 'LOCAL'}  " > selected=""</c:if> >LOCAL</option>

                                    <option value="INTERNACIONAL" <c:if test="${convenio_editJSP.convenio_origen == 'INTERNACIONAL'} " > selected=""</c:if> >INTERNACIONAL</option>



                                </select>
                                <label for="floatingSelect">Origen Convenio</label>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <select name="convenio_vigente_edit" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                    <option value="VIGENTE">VIGENTE</option>

                                    <option value="NO_VIGENTE">NO VIGENTE</option>



                                </select>
                                <label for="floatingSelect">Estado Convenio</label>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-floating mb-3">
                                <input name="curso_pdf_edit" type="file" class="form-control" id="floatingInput" placeholder="s   ">

                            </div>

                        </div>

                    </div>
                    <div class="mb-3">
                        <button class="btn btn-success px-4 shadow" type="submit">
                            <i class="fa-solid fa-floppy-disk"></i>
                            Save
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