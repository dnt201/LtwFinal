package com.example.ltwnhom10.controller.cart;

import com.example.ltwnhom10.model.OrderDetailsModel;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCardController", urlPatterns = {"/add-to-cart"})
public class addToCartController extends HttpServlet {
    private IProductService productService;

    public addToCartController() {this.productService = new ProductService(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer quantity = 1;
        Integer id;

        if (request.getParameter("product_id")!=null){
            id = Integer.parseInt(request.getParameter("product_id"));
            ProductModel product = productService.findByID(id);

            if (product != null && request.getParameter("quantity") != null){
                    quantity = Integer.parseInt(request.getParameter("quantity"));
            }

            HttpSession session = request.getSession();
            if (session.getAttribute("order") == null){
                BigDecimal total = new BigDecimal("0");
                OrderDetailsModel order = new OrderDetailsModel();
                List<OrderItemsModel> listItems = new ArrayList<OrderItemsModel>();
                OrderItemsModel item = new OrderItemsModel();

                item.setQuantity(quantity);
                item.setProductModel(product);

                listItems.add(item);
                order.setOrderItemsList(listItems);

                BigDecimal number = new BigDecimal(quantity);
                order.setTotal((total.add(product.getPrice())).multiply(number));
                session.setAttribute("order", order);
            }
            else {
                OrderDetailsModel order = (OrderDetailsModel) session.getAttribute("order");
                List<OrderItemsModel> listItems = order.getOrderItemsList();
                boolean check = false;
                for (OrderItemsModel item : listItems) {
                    if (item.getProductModel().getProduct_id() == product.getProduct_id()) {
                        BigDecimal total = new BigDecimal("0");
                        BigDecimal number = new BigDecimal(quantity);
                        item.setQuantity(item.getQuantity() + quantity);
                        order.setTotal(order.getTotal().add(product.getPrice().multiply(number)));
                        check = true;
                    }
                }
                if (check == false) {
                    OrderItemsModel item = new OrderItemsModel();
                    item.setQuantity(quantity);
                    item.setProductModel(product);
                    listItems.add(item);
                    BigDecimal j = new BigDecimal(quantity);
                    order.setTotal(order.getTotal().add(product.getPrice().multiply(j)));
                }
                session.setAttribute("order", order);
            }
            response.sendRedirect(request.getContextPath() + "/cart");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/home-page");
        }
    }

}
