package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.utl.FormUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailProductController", value = "/detail-product")
public class DetailProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel productModel = FormUtil.toModel(ProductModel.class, request);
        String url = "";
        //productModel = productService.findByID(Integer.parseInt(request.getParameter("productId")));
        //request.setAttribute(WebConstant.MODEL, productModel);
        //productModel.setListResult(productService.findByManufacture(productModel.getManufact().getManufactId()));
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/detailProduct.jsp");
        rd.forward(request, response);
        System.out.println("Get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
