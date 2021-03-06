<%-- 
    Document   : home
    Created on : 17/03/2022, 12:50:54 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> - Home Admin -</title>
        <jsp:include page="inc/stilo.jsp"></jsp:include>
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


            <jsp:include page="inc/sidebaradmin.jsp"></jsp:include>


                <!-- Content Start -->
                <div class="content">


                <jsp:include page="inc/navbaradmin.jsp"></jsp:include>

                    <!-- Sale & Revenue Start -->
                    <div class="container-fluid pt-4 px-4">
                        <div class="row g-4">
                            <div class="col-sm-6 col-xl-3">
                                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                    <i class="fa fa-chart-line fa-3x text-primary"></i>
                                    <div class="ms-3">
                                        <p class="mb-2">Today Sale</p>
                                        <h6 class="mb-0">$1234</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-3">
                                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                    <i class="fa fa-chart-bar fa-3x text-primary"></i>
                                    <div class="ms-3">
                                        <p class="mb-2">Total Sale</p>
                                        <h6 class="mb-0">$1234</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-3">
                                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                    <i class="fa fa-chart-area fa-3x text-primary"></i>
                                    <div class="ms-3">
                                        <p class="mb-2">Today Revenue</p>
                                        <h6 class="mb-0">$1234</h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-3">
                                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                    <i class="fa fa-chart-pie fa-3x text-primary"></i>
                                    <div class="ms-3">
                                        <p class="mb-2">Total Revenue</p>
                                        <h6 class="mb-0">$1234</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Sale & Revenue End -->


                    <!-- Recent Sales Start -->
                    <div class="container-fluid pt-4 px-4">
                        <div class="bg-light text-center rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Recent Salse</h6>
                                <a href="">Show All</a>
                            </div>
                            <div class="table-responsive">
                                <table class="table text-start align-middle table-bordered table-hover mb-0">
                                    <thead>
                                        <tr class="text-dark">
                                            <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                            <th scope="col">Date</th>
                                            <th scope="col">Invoice</th>
                                            <th scope="col">Customer</th>
                                            <th scope="col">Amount</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>01 Jan 2045</td>
                                            <td>INV-0123</td>
                                            <td>Jhon Doe</td>
                                            <td>$123</td>
                                            <td>Paid</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>01 Jan 2045</td>
                                            <td>INV-0123</td>
                                            <td>Jhon Doe</td>
                                            <td>$123</td>
                                            <td>Paid</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>01 Jan 2045</td>
                                            <td>INV-0123</td>
                                            <td>Jhon Doe</td>
                                            <td>$123</td>
                                            <td>Paid</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>01 Jan 2045</td>
                                            <td>INV-0123</td>
                                            <td>Jhon Doe</td>
                                            <td>$123</td>
                                            <td>Paid</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>01 Jan 2045</td>
                                            <td>INV-0123</td>
                                            <td>Jhon Doe</td>
                                            <td>$123</td>
                                            <td>Paid</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Recent Sales End -->

                    <!-- Blank Start -->
                    <div class="container-fluid pt-4 px-4">
                        <div class="row vh-100 bg-light rounded align-items-center justify-content-center mx-0">
                            <div class="col-md-6 text-center">




                            </div>
                        </div>
                    </div>
                    <!-- Blank End -->




                <jsp:include page="inc/footer.jsp"></jsp:include>
                </div>
                <!-- Content End -->










            <jsp:include page="inc/scriptsadmin.jsp"></jsp:include>
        </div>
    </body>
</html>
