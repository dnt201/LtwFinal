package com.example.ltwnhom10.controller.cart;

import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
    private IProductService productService;
    public CartController() {
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url ="/views/cart/cart.jsp"; //homepage

        if(action == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/cart.jsp");
            dispatcher.forward(request, response);
        }
        else if(action.equals("add")){
            Integer quantity = 1;
            Integer id;
            if(request.getParameter("product_id")!=null){
                id = Integer.parseInt(request.getParameter("product_id"));
                ProductModel product = productService.findByID(id);
                if(product != null && request.getParameter("quantity") != null){
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                if(session.getAttribute("order") == null){
                    BigDecimal total = new BigDecimal("0");
                    //tạo cart mới
                    OrderDetailsModel order = new OrderDetailsModel();
                    //list lưu các line của cart
                    List<OrderItemsModel> listItems = new ArrayList<OrderItemsModel>();
                    //line
                    OrderItemsModel item = new OrderItemsModel();
                    item.setQuantity(quantity);
                    item.setProductModel(product);
                }
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}