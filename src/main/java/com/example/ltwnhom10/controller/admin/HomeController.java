package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
        if (user == null ){
            response.sendRedirect(
                    request.getContextPath() + "/login?action=login");
        }
        else if (user.getRoleModel().getRoleName() == CoreConstant.ROLE_USER){
            response.sendRedirect(
                    request.getContextPath() + "/logout");
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/adminPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
