package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IBrandService;
import com.example.ltwnhom10.service.IDiscountService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.BrandService;
import com.example.ltwnhom10.service.impl.DiscountService;
import com.example.ltwnhom10.service.impl.ProductService;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductAdmin", urlPatterns = {"/admin/product"})
public class ProductController extends HttpServlet {

    private IProductService productService;
    private IBrandService brandService;
    private IDiscountService discountService;

    public ProductController(){
        this.brandService = new BrandService();
        this.productService = new ProductService();
        this.discountService = new DiscountService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductModel product = FormUtil.toModel(ProductModel.class, request);
        String url = "";
        String action = request.getParameter("action");

        switch (action){
            case "insert": {
                url = url = "/views/admin/Insert/InsertProduct.jsp";
            }
            case "edit": {
                url = "/views/admin/Insert/InsertProduct.jsp";
                Integer id = Integer.parseInt(request.getParameter("product_id"));
                product = productService.findByID(id);
                request.setAttribute("productModel", product);
                request.setAttribute("brandModel", brandService.findAll());
                request.setAttribute("discountModel", discountService.findAll());
            }
            case "add": {
                product = HttpUtil.of(request.getReader()).toModel(ProductModel.class);
                productService.save(product);

                url = "/views/admin/List/ListProduct.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Product Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
            }
            case "update": {
                product = HttpUtil.of(request.getReader()).toModel(ProductModel.class);
                productService.update(product);

                request.setAttribute("productModel", product);
                url = "/views/admin/Insert/InsertProduct.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Product Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
            }
            default: {
                url = "/views/admin/List/ListProduct.jsp";
                ProductModel model = new ProductModel();
                model.setListResult(productService.findAll());
                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute("brandModel", brandService.findAll());
                request.setAttribute("discountModel", discountService.findAll());
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
            requestDispatcher.forward(request, response);
        }
    }
}
