package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.*;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class HomeController extends HttpServlet {
    private IProductService productService;
    private IOrderDetailsService orderDetailsService;
    private IUserService userService;


    public HomeController() {
        this.productService = new ProductService();
        this.orderDetailsService = new OrderDetailsService();
        this.userService = new UserService();
    }
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
            ProductModel product = new ProductModel();
            product.setListResult(productService.findAll());
            request.setAttribute("productQty", product.getListResult().size());


            OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
            orderDetailsModel.setListResult(orderDetailsService.findAll());
            request.setAttribute("orderQty",orderDetailsModel.getListResult().size());

            BigDecimal total = BigDecimal.ZERO;
            orderDetailsModel.getListResult();
            for( int i = 0;i<orderDetailsModel.getListResult().size();i++) {
                total = total.add(orderDetailsModel.getListResult().get(i).getTotal());
            }
            request.setAttribute("totalMoney",total);

            UsersModel users = FormUtil.toModel(UsersModel.class, request);
            users.setListResult(userService.findAll());
            request.setAttribute("userQty",users.getListResult().size());

            System.out.println("productQty"+product.getListResult().size());
            System.out.println("orderQty"+orderDetailsModel.getListResult().size());
            System.out.println("totalMoney"+total);
            System.out.println("userQty"+users.getListResult().size());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/admin/adminPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
