package com.example.ltwnhom10.controller.Web;


import com.example.ltwnhom10.constance.*;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.Bcrypt;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/home-page", "/login", "/logout"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("login")){
            String alert = request.getParameter("alert");
            String message = request.getParameter("message");
            if (message!=null && alert!=null){
                request.setAttribute("messageResponse", message);
                request.setAttribute("alert", alert);
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/login.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (action != null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
            //SessionUtil.getInstance().removeValue(request, order);
            response.sendRedirect(request.getContextPath()+"/home-page");
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/home.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserService();
        String action = request.getParameter("action");

        if (action != null && action.equals("login")) {
            UsersModel model = FormUtil.toModel(UsersModel.class, request);
            Bcrypt bcrypt = new Bcrypt(10);
            UsersModel user = userService.isUserExist(model);

            if (user != null) {
                if (bcrypt.verifyAndUpdateHash(model.getPassword(), user.getPassword())) {
                    SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, user);
                    String role = user.getRoleModel().getRoleName();
                    if (role.equals(CoreConstant.ROLE_USER)) {
                        response.sendRedirect(request.getContextPath() + "/home");
                    } else if (role.equals(CoreConstant.ROLE_ADMIN)) {
                        response.sendRedirect(request.getContextPath() + "/admin-home");
                    }
                }
            } else if (model != null) {
                model = userService.findByUsernameAndPassword(model.getUsername(), model.getPassword());
                SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, model);
                String role = user.getRoleModel().getRoleName();
                if (role.equals(CoreConstant.ROLE_USER)) {
                    response.sendRedirect(request.getContextPath() + "/home");
                } else if (role.equals(CoreConstant.ROLE_ADMIN)) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            }else {
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "User Name or Password was wrong!");
//                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        else{
            request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "User Name or Password was wrong!");
//                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}