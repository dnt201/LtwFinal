<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="form_login_container">
    <form class="wrap-login flex_column_center" onSubmit={submitHandler}>
        <span >Login</span>
        <p><i>Welcome back to my shop!</i></p>

        <div class="w100">
            <label class="m-b-4px">Username</label>
            <input class="m-b-12px w100"
                   type="email"
                   placeholder="Enter your username address..."
                   required
            />
        </div>
        <div class=" w100">
            <label class="m-b-4px">Password</label>
            <input class="w100 m-b-12px"
                   type="password"
                   placeholder="Enter your password..."
                   required
            />
        </div>
        <button class="login-btn" type="submit" >Login</button>
        <p class="login-bottom-text">Don't have a account yet? <a to="/register"> Click here to register!</a> </p>
    </form>
</div>
