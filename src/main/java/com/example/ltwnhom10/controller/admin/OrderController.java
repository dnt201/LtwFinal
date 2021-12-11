package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.impl.OrderDetailsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController", urlPatterns = {"/admin/order"})
public class OrderController extends HttpServlet {
    private IOrderDetailsService orderDetailsService;

    public OrderController() {this.orderDetailsService = new OrderDetailsService(); }

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
        orderDetailsModel.setListResult(orderDetailsService.findAll());

        request.setAttribute(CoreConstant.MODEL, orderDetailsModel);
        String url = "/views/admin/list/OrderList.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
