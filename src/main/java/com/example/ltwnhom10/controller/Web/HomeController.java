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

@WebServlet(name = "HomeController", urlPatterns = {"/home-page", "/login", "/logout","/about"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("login")){
            String message = request.getParameter("message");
           if(message!=null){
               if(message.equals("username_password_invalid"))
                   request.setAttribute("messageResponse", "Tài khoản hoặc mật khẩu không đúng, vui lòng thử lại!");
               else if(message.equals("not_login"))
                   request.setAttribute("messageResponse","Đăng nhập để hoàn tất đơn hàng!");
               else if(message.equals("not-yet-login"))
                   request.setAttribute("messageResponse","Bạn chưa đăng nhập!");
           }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/login.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (action != null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
            System.out.println("Logout");
            //SessionUtil.getInstance().removeValue(request, order);
            response.sendRedirect(request.getContextPath()+"/login?action=login");
        }
        else if(action != null && action.equals("about")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/about.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (action != null && action.equals("products")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/products.jsp");
            requestDispatcher.forward(request, response);
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
                        response.sendRedirect(request.getContextPath() + "/home-page");
                    } else if (role.equals(CoreConstant.ROLE_ADMIN)) {
                        response.sendRedirect(request.getContextPath() + "/admin");
                    }
                }
                else{ request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
                    response.sendRedirect(request.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
                }
            }
            else {
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
            }
        }
        else{
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Username or password is incorrect!");
            response.sendRedirect(request.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
        }
    }
}