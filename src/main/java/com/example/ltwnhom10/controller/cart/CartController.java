package com.example.ltwnhom10.controller.cart;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.*;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.IOrderItemsService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.OrderDetailsService;
import com.example.ltwnhom10.service.impl.OrderItemsService;
import com.example.ltwnhom10.service.impl.ProductService;
import com.example.ltwnhom10.utl.SessionUtil;
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
    private IOrderDetailsService orderDetailsService;
    private IOrderItemsService orderItemsService;

    public CartController() {
        this.productService = new ProductService();
        this.orderDetailsService = new OrderDetailsService();
        this.orderItemsService = new OrderItemsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/views/cart/cart.jsp"; //homepage

        if (action == null) {
            String message = request.getParameter("message");
            if(message!=null){
                if(message.equals("removeSuccess"))
                    request.setAttribute("messageResponse", "Xoá thành công");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/cart.jsp");
            dispatcher.forward(request, response);
        }
        else if (action.equals("add")) {
            Integer quantity = 1;
            Integer id;
            if (request.getParameter("product_id") != null) {
                id = Integer.parseInt(request.getParameter("product_id"));
                ProductModel product = productService.findByID(id);
                if (product != null && request.getParameter("quantity") != null) {
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                if (session.getAttribute("order") == null) {
                    BigDecimal total = new BigDecimal("0");
                    //tạo cart mới
                    OrderDetailsModel order = new OrderDetailsModel();
                    //list lưu các line của cart
                    List<OrderItemsModel> listItems = new ArrayList<OrderItemsModel>();
                    //line
                    OrderItemsModel item = new OrderItemsModel();
                    item.setQuantity(quantity); //Đã được cập nhập số lượng
                    item.setProductModel(product);
                    listItems.add(item);
                    order.setOrderItemsList(listItems);
                    BigDecimal j = new BigDecimal(quantity);
                    order.setTotal(total.add((product.getPrice().subtract((product.getPrice().multiply(product.getDiscount().getDiscountPercent())
                            .divide(BigDecimal.valueOf(100))))).multiply(j)));
                    // Tính giá sản bill
                    session.setAttribute("order", order);
                } else { //nếu đã có cart
                    OrderDetailsModel order = (OrderDetailsModel) session.getAttribute("order");
                    List<OrderItemsModel> listItems = order.getOrderItemsList();
                    boolean check = false;
                    //Check xem đã tồn tại trong cart chưa
                    for (OrderItemsModel item : listItems) {
                        if (item.getProductModel().getProduct_id() == product.getProduct_id()) {
                            BigDecimal total = new BigDecimal("0");
                            BigDecimal number = new BigDecimal(quantity);
                            item.setQuantity(item.getQuantity() + quantity);
                            order.setTotal(order.getTotal().add((product.getPrice().subtract((product.getPrice().multiply(product.getDiscount().getDiscountPercent())
                                    .divide(BigDecimal.valueOf(100))))).multiply(number)));
                            check = true;

                        }
                    }
                    //không có sản phẩm thì thêm mới
                    if (check == false) {
                        OrderItemsModel item = new OrderItemsModel();
                        item.setQuantity(quantity);
                        item.setProductModel(product);
                        listItems.add(item);
                        BigDecimal j = new BigDecimal(quantity);
                        order.setTotal(order.getTotal().add((product.getPrice().subtract((product.getPrice().multiply(product.getDiscount().getDiscountPercent())
                                .divide(BigDecimal.valueOf(100))))).multiply(j)));
                    }
                    session.setAttribute("order", order);
                }
                response.sendRedirect(request.getContextPath() + "/cart");
            } else {
                response.sendRedirect(request.getContextPath() + "/home-page");
            }
        }
        else if (action.equals("remove")){
            OrderDetailsModel order = (OrderDetailsModel) session.getAttribute("order");
            List<OrderItemsModel> listItems = order.getOrderItemsList();

            int id = Integer.parseInt(request.getParameter("product_id"));

            for (int i=0;i<listItems.size();i++) {
                if (listItems.get(i).getProductModel().getProduct_id() == id){
                    OrderItemsModel orderItemsModel = listItems.get(i);
                    order.setTotal(order.getTotal().subtract(BigDecimal.valueOf(orderItemsModel.getQuantity()).multiply(orderItemsModel.getProductModel().getPrice()
                            .subtract(orderItemsModel.getProductModel().getPrice().multiply(orderItemsModel.getProductModel().getDiscount().getDiscountPercent().divide(BigDecimal.valueOf(100)))))));

                    listItems.remove(listItems.get(i));
                    break;
                }
            }

            order.setOrderItemsList(listItems);

            SessionUtil.getInstance().removeValue(request, "order");
            session.setAttribute("order", order);

            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/cart?message=removeSuccess");
        }
        else if (action.equals("update")){
            OrderDetailsModel order = (OrderDetailsModel) session.getAttribute("order");
            List<OrderItemsModel> listItems = order.getOrderItemsList();

            int id = Integer.parseInt(request.getParameter("product_id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int old_quantity = 0;

            for (int i=0;i<listItems.size();i++)
                if (listItems.get(i).getProductModel().getProduct_id() == id) {
                    if (quantity < 1)
                        listItems.remove(listItems.get(i));
                    else {
                        old_quantity = listItems.get(i).getQuantity();
                        listItems.get(i).setQuantity(quantity);
                        OrderItemsModel orderItemsModel = listItems.get(i);
                        order.setTotal(order.getTotal().add(BigDecimal.valueOf(quantity-old_quantity).multiply(orderItemsModel.getProductModel().getPrice()
                                .subtract(orderItemsModel.getProductModel().getPrice().multiply(orderItemsModel.getProductModel().getDiscount().getDiscountPercent().divide(BigDecimal.valueOf(100)))))));
                    }
                    break;
                }

            order.setOrderItemsList(listItems);

            SessionUtil.getInstance().removeValue(request, "order");
            session.setAttribute("order", order);

            response.sendRedirect(request.getContextPath() + "/cart?message=updateSuccess");
        }
        else if(action.equals("checkout")){
            UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, "User");
            if (user == null) {
                response.sendRedirect(
                        request.getContextPath() + "/login-dang-nhap?action=login&messageResponse=not_login");
            } else {
                if (SessionUtil.getInstance().getValue(request, "order") == null) {
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Giỏ hàng rỗng, không thể thanh toán");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/cart.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    OrderDetailsModel order = (OrderDetailsModel) SessionUtil.getInstance().getValue(request, "order");
                    order.setUsersModel(user);

                    Integer orderDetailId = orderDetailsService.save(order);
                    order.setOrder_id(orderDetailId);

                    List<OrderItemsModel> listItems = order.getOrderItemsList();
                    for (OrderItemsModel item : listItems) {
                        OrderItemsKey orderItemsKey = new OrderItemsKey();
                        orderItemsKey.setOrder_id(orderDetailId);
                        orderItemsKey.setProduct_id(item.getProductModel().getProduct_id());
                        item.setId(orderItemsKey);

                        item.setOrderDetails(order);
                        orderItemsService.save(item);
                    }
                    SessionUtil.getInstance().removeValue(request, "order");
                    request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Check Out successfully an email will send to your mail!");
                    RequestDispatcher rd = request.getRequestDispatcher("views/cart/cart.jsp"); // xem form detail product + thanks
                    rd.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}