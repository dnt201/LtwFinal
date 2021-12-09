<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!--Bootsrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/assets/admin/css/sb-admin-2.min.css'/> ">
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/assets/admin/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/assets/admin/js/sb-admin-2.min.js'/>"></script>
    <script src="<c:url value='/assets/admin/js/bootstrap.bundle.js'/>"></script>
    <!-- My javascript -->

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css" />
    <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
    <link href="<c:url value='/assets/admin/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/assets/admin/fontawesome-free/css/all.css'/>" rel="stylesheet" type="text/css">


    <!-- My Css -->
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/assets/web/css/header.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/assets/web/css/footer.css'/> ">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/assets/admin/css/form-custom.css'/> ">

    <!-- Font family -->
    <link href="https://fonts.googleapis.com/css2?family=Chakra+Petch:wght@300&family=Genos:wght@300&display=swap"
          rel="stylesheet">
    <!-- Custom fonts for this template-->

</head>

<body id="page-top">
<%@ include file="/common/web/header.jsp" %>
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <%@ include file="/common/admin/navleft.jsp" %>
    <div id="content-wrapper" class="d-flex flex-column">
        <dec:body/>
    </div>
</div>
<button onclick="topFunction()" id="myBtn-scroll-top" title="Go to top"><i class="fa fa-angle-double-up"></i></button>

<%@ include file="/common/web/footer.jsp" %>
<script src="<c:url value='/assets/web/js/navbar.js'/>"></script>
</body>

</html>