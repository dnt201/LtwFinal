package com.example.ltwnhom10.controller.Web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.model.RoleModel;
import com.example.ltwnhom10.model.UsersModel;
//import com.example.projectshoes.paging.PageRequest;
//import com.example.projectshoes.paging.Pageble;
//import com.example.ltwnhom10.service.IProductService;

import com.example.ltwnhom10.service.IRoleService;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.utl.SessionUtil;

//import com.example.projectshoes.utils.FormUtil;
//import com.example.projectshoes.utils.SessionUtil;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HomeController", urlPatterns = {"/home-page", "/login", "/logout"})
public class HomeController extends HttpServlet {

    @Inject
    IRoleService roleService;
    @Inject
    IUserService userService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String url="";

        if(action != null && action.equals("login")) {
            url="/views/web/login.jsp";
            System.out.println("login");
        }
        else if (action != null && action.equals("logout")){
            System.out.println("logout");
        }
        else {
            url="/views/web/home.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
