<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="form_register_container">
    <form class="wrap-register" method="post">
        <span >Register</span>
        <p><i>Many thanks for your registration!</i></p>

        <div class="wrap_name_email flex_row_around w100 m-t-8px">
            <div class="form_control wrap_name flex_column_start w48">
                <label class="m-b-4px">Name</label>
                <input id="nameInput"
                       name="name"
                       class="m-b-4px w100 p-lr-4px w100" placeholder="Enter your name..."
                       required
                />
            </div>
            <div class="form_control wrap_email flex_column_start w48">
                <label class="m-b-4px">Email</label>
                <input id="emailInput"
                       name="email"
                       class="m-b-4px w100 p-lr-4px w100" type="email" placeholder="Enter your email address..."
                       required
                />
            </div>
        </div>
        <div class="form_control wrap_address flex_column_start w100">
            <label class="m-b-4px">Address</label>
            <input id="addressInput"
                   name="address"
                   class="w100 m-b-4px p-lr-4px" type="text" placeholder="Enter your password..."
            />
        </div>
        <div class="form_control wrap_address flex_column_start w100">
            <label class="m-b-4px">Phone number</label>
            <input id="phoneNumber"
                   name="phone"
                   class="w100 m-b-4px p-lr-4px" type="text" placeholder="Enter your phone number..."
            />
        </div>
        <div class="form_control wrap_password flex_column_start w100">
            <label class="m-b-4px">Username</label>
            <input id="usernameInput"
                   name="username"
                   class="w100 m-b-4px p-lr-4px" type="text" placeholder="Enter your username..."
                   required
            />
        </div>
        <div class="form_control wrap_password flex_column_start w100">
            <label class="m-b-4px">Password</label>
            <input id="passwordInput"
                   name="password"
                   class="w100 m-b-4px p-lr-4px" type="password" placeholder="Enter your password..."
                   required
            />
        </div>
        <div class="form_control wrap_conf_password flex_column_start w100">
            <label class="m-b-4px">Confirm Password</label>
            <input id="confPasswordInput" class="w100 m-b-4px p-lr-4px"
                   type="password" placeholder="Confirm password..."
                   required
            />
        </div>
        <i class="red_16px_bold">{message}</i>
        <button class="register-btn" type="submit">Register</button>
    </form>
</div>