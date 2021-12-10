package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IBrandService;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.BrandService;
import com.example.ltwnhom10.service.impl.OrderDetailsService;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderDetailController", value = "/order/detail")
public class OrderDetailController extends HttpServlet {


    private IOrderDetailsService orderDetailsService;

    public OrderDetailController() {
        this.orderDetailsService = new OrderDetailsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDetailsModel orderDetailsModel = orderDetailsService.findById(Integer.parseInt(request.getParameter("order_id")));
        UsersModel usersModel = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);

        if (orderDetailsModel == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/detailOrder.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (usersModel == null){
            response.sendRedirect(request.getContextPath() + "/login?action=login");
        }
        else if ((usersModel.getRoleModel().getRoleName().equals(CoreConstant.ROLE_ADMIN)) ||
                (usersModel.getUsername().equals(orderDetailsModel.getUsersModel().getUsername()))){
            request.setAttribute(CoreConstant.MODEL, orderDetailsModel);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/detailOrder.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/home-page");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
