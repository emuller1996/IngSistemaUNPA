<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="row  bg-light rounded align-items-center justify-content-center mx-0">
                    <div class="col-md-6 text-center">
                        <h3>This is blank page</h3>
                        <p>Estefano Muller</p>

                        
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