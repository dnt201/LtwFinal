package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.paging.PageRequest;
import com.example.ltwnhom10.paging.Pageable;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.ProductService;
import com.example.ltwnhom10.sort.Sorter;
import com.example.ltwnhom10.utl.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController", urlPatterns={"/products"})
public class ProductController extends HttpServlet {
    private IProductService productService;
    public ProductController() { this.productService = new ProductService(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductModel product = FormUtil.toModel(ProductModel.class, request);
        //tien - brand - discount
        Pageable pageable = new PageRequest(product.getPage(),product.getMaxPageItem(),new Sorter(product.getSortName(),product.getSortBy()));
        product.setListResult(productService.findAllPaging(pageable));
        product.setTotalItem(productService.getTotalItem());
        product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));
        request.setAttribute(CoreConstant.MODEL, product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product/product.jsp");
        requestDispatcher.forward(request, response);
    }
}
