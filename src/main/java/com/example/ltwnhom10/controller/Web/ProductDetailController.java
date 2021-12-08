package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.ProductService;
import com.example.ltwnhom10.utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDetail", urlPatterns = {"/product/detail"})
public class ProductDetailController extends HttpServlet {
    private IProductService productService;

    public ProductDetailController(){
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductModel product = FormUtil.toModel(ProductModel.class, request);
        String url = "";
        product = productService.findByID(Integer.parseInt(request.getParameter("product_id")));
        request.setAttribute(CoreConstant.MODEL, product);
        product.setListResult(productService.findByBrand(product.getBrandModel().getBrand_id()));
        request.setAttribute("OtherProducts", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/product/productDetails.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
