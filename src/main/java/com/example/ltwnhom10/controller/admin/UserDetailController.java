package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.ProductService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDetail", urlPatterns = {"/admin/user/detail"})
public class UserDetailController extends HttpServlet {
    private IUserService userService;

    public UserDetailController(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersModel product = FormUtil.toModel(UsersModel.class, request);
        product = userService.findByID(Integer.parseInt(request.getParameter("user_id")));
        request.setAttribute(CoreConstant.MODEL, product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/userDetails.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
