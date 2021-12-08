package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAdmin", urlPatterns = {"/admin/user"})
public class UserController extends HttpServlet {

    @Inject
    private IUserService userService;

    public UserController() { this.userService = new UserService(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersModel users = FormUtil.toModel(UsersModel.class, request);
        users.setListResult(userService.findAll());

        request.setAttribute(CoreConstant.MODEL, users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/admin/List/ListUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
