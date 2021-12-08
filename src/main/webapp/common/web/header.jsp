<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="nav"  id="top-nav" >
    <div class="menu-icons" onclick="toggleNav()">
        <i class="fas fa-bars"></i>
        <i class="fas fa-times"></i>
    </div>

    <a href="<c:url value='/'/>" class="logo">
        <img
                src="<c:url value='/assets/web/images/logo.jpg'/>"
                alt="Logo"/>
    </a>
    <ul class="nav-list">
        <li>
            <a href="<c:url value='/home-page'/>">Home</a>
        </li>
        <li>
            <a href="<c:url value='/about'/>">About</a>
        </li>
        <li>
            <a href="<c:url value='/products?action=products'/>">Products</a>
        </li>
        <div class="move-right">
            <li class="cover-size btn user">
                <a href="<c:url value='/cart'/>">
                    <!-- <FontAwesomeIcon icon={faShoppingCart}/>-->
                    <span class="number-items-cart"><i class="fas fa-truck"></i> </span>
                </a>
            </li>

            <li class="cover-size btn user">
                <a href="<c:url value='/user'/>">
                    <!--<FontAwesomeIcon icon={faUser}/>-->
                </a>
            </li>
            <c:if test="${not empty User}">
            <li class="cover-size btn login">
                <a href="<c:url value='/logout?action=logout'/>">
                    Logout</a>
            </li>
            </c:if>
            <c:if test="${empty User}">
                <li class="cover-size btn login">
                    <a href="<c:url value='/login?action=login'/>">
                        Login</a>
                </li>
                <li class="cover-size btn login">
                    <a href="<c:url value='/register?action=register'/>">
                        Register</a>
                </li>
            </c:if>
            <li class="cover-size btn admin">
                <a href="<c:url value='/admin'/>">
                    Admin</a>
            </li>
        </div>
    </ul>
</header>
