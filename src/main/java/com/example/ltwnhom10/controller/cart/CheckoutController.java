package com.example.ltwnhom10.controller.cart;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.IOrderItemsService;
import com.example.ltwnhom10.service.impl.OrderDetailsService;
import com.example.ltwnhom10.service.impl.OrderItemsService;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CheckoutController", urlPatterns = {"/check-out"})
public class CheckoutController extends HttpServlet {

    private IOrderDetailsService orderDetailsService;
    private IOrderItemsService orderItemsService;

    public CheckoutController(){
        this.orderDetailsService = new OrderDetailsService();
        this.orderItemsService = new OrderItemsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
        if (user == null) {
            response.sendRedirect(
                    request.getContextPath() + "/login-dang-nhap?action=login&messageResponse=not_login&alert=danger");
        } else {
            if (SessionUtil.getInstance().getValue(request, "order") == null) {
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_ERROR);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "You don't have any thing to check out!");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/cart.jsp");
                requestDispatcher.forward(request, response);
            } else {
                OrderDetailsModel order = (OrderDetailsModel) SessionUtil.getInstance().getValue(request, "order");
                order.setUsersModel(user);
                Integer orderDetailId = orderDetailsService.save(order);
                order.setOrder_id(orderDetailId);
                List<OrderItemsModel> listItems = order.getOrderItemsList();
                for (OrderItemsModel item : listItems) {
                    item.setOrderDetails(order);
                    orderItemsService.save(item);
                }
                SessionUtil.getInstance().removeValue(request, "order");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Check Out successfully an email will send to your mail!");
                RequestDispatcher rd = request.getRequestDispatcher("views/web/cart.jsp");
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
