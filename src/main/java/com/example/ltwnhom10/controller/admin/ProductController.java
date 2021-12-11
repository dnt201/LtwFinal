package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IBrandService;
import com.example.ltwnhom10.service.IDiscountService;
import com.example.ltwnhom10.service.IOrderItemsService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.BrandService;
import com.example.ltwnhom10.service.impl.DiscountService;
import com.example.ltwnhom10.service.impl.OrderItemsService;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAdmin", urlPatterns = {"/admin/product"})
public class ProductController extends HttpServlet {

    private IProductService productService;
    private IBrandService brandService;
    private IDiscountService discountService;
    private IOrderItemsService orderItemsService;

    public ProductController() {
        this.brandService = new BrandService();
        this.productService = new ProductService();
        this.discountService = new DiscountService();
        this.orderItemsService = new OrderItemsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel product = null;
        String url = "";
        String action = request.getParameter("action");
        if (action == null) {
            url = "/views/admin/list/ProductList.jsp";
            ProductModel model = new ProductModel();
            model.setListResult(productService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
//            request.setAttribute("brandModel", brandService.findAll());
//            request.setAttribute("discountModel", discountService.findAll());
        }
        else if (action.equals(CoreConstant.ACTION_INSERT)) {
//            request.setAttribute("brandModel", brandService.findAll());
//            request.setAttribute("discountModel", discountService.findAll());
            url = "/views/admin/insert/ProductInsert.jsp";
        }
        else if (action.equals(CoreConstant.ACTION_EDIT)) {
            url = "/views/admin/insert/ProductInsert.jsp";
            Integer id = Integer.parseInt(request.getParameter("product_id"));
            product = productService.findByID(id);
            request.setAttribute(CoreConstant.MODEL, product);
//            request.setAttribute("brandModel", brandService.findAll());
//            request.setAttribute("discountModel", discountService.findAll());
        }
        else if (action.equals(CoreConstant.ACTION_ADD)) {
            product = FormUtil.toModel(ProductModel.class, request);

            DiscountModel discount = new DiscountModel();
            BrandModel brand = new BrandModel();

            brand.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
            discount.setDiscount_id(Integer.parseInt(request.getParameter("discount_id")));

            product.setDiscount(discount);
            product.setBrandModel(brand);
            productService.save(product);

            url = "/views/admin/insert/ProductInsert.jsp";
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Product Success");
        }
        else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            product = FormUtil.toModel(ProductModel.class, request);

            DiscountModel discount = new DiscountModel();
            BrandModel brand = new BrandModel();

            brand.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
            discount.setDiscount_id(Integer.parseInt(request.getParameter("discount_id")));

            product.setDiscount(discount);
            product.setBrandModel(brand);
            productService.update(product);
            request.setAttribute(CoreConstant.MODEL, product);
//            request.setAttribute("brandModel", brandService.findAll());
//            request.setAttribute("discountModel", discountService.findAll());
            url = "/views/admin/insert/ProductInsert.jsp";
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Product Success");
        }
        else if (action.equals(CoreConstant.ACTION_DELETE)){
            Integer id = Integer.parseInt(request.getParameter("product_id"));
            List<OrderItemsModel> orderItemsModels = orderItemsService.findByProductId(id);

            if (orderItemsModels.size() > 0){
                url = "/views/admin/list/ProductList.jsp";
                ProductModel model = new ProductModel();
                model.setListResult(productService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Product Fail");
            }
            else {
                productService.deleteOne(productService.findByID(id));

                ProductModel model = new ProductModel();
                model.setListResult(productService.findAll());
                request.setAttribute(CoreConstant.MODEL, model);

                url = "/views/admin/list/ProductList.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Product Success");
            }
        }
        else {
            url = "/views/admin/list/ProductList.jsp";
            ProductModel model = new ProductModel();
            model.setListResult(productService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
//            request.setAttribute("brandModel", brandService.findAll());
//            request.setAttribute("discountModel", discountService.findAll());
        }

        request.setAttribute("brandModel", brandService.findAll());
        request.setAttribute("discountModel", discountService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
