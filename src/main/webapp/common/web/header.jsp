<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="nav">
    <div class="menu-icons" onClick={toggleNav}>
        <!--<FontAwesomeIcon icon={faBars}/>
        <FontAwesomeIcon icon={faTimes}/>-->
    </div>
    <a to="/#" class="logo">
        <img
                src="1"
                alt="Logo"/>
    </a>
    <ul class="nav-list">
        <li>
            <a to="/">Home</a>
        </li>
        <li>
            <a to="/about">About</a>
        </li>
        <li>
            <a to="/products">Products</a>
        </li>
        <div class="move-right">

            <li class="cover-size btn user">
                <a to="/cart">
                    <!-- <FontAwesomeIcon icon={faShoppingCart}/>-->
                    <span class="number-items-cart"><i class="fas fa-truck"></i></span>
                </a>
            </li>
        </div>
        <li class="cover-size btn user">
            <a to="/user">
                <!--<FontAwesomeIcon icon={faUser}/>-->
            </a>
        </li>

        <li class="cover-size btn logout">
            <button>Log out</button>
        </li>

        <li class="cover-size btn login">
            <a to="/login">
                Login</a>
        </li>
        <li class="cover-size btn login">
            <a to="/register">
                Register</a>
        </li>
        <li class="cover-size btn admin">
            <a to="/admin">
                Admin</a>
        </li>

    </ul>
</header>
