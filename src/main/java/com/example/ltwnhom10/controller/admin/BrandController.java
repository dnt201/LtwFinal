package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.service.IBrandService;
import com.example.ltwnhom10.service.impl.BrandService;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BrandController", urlPatterns = {"/admin-brand"})
public class BrandController extends HttpServlet {
    private IBrandService brandService;

    public BrandController() {this.brandService = new BrandService();}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BrandModel brand = null;
        String url = "";
        String action = request.getParameter("action");

        switch (action){
            case "insert":{
                url = "/views/admin/Insert/InsertBrand.jsp";
            }
            case "edit": {
                url = "/views/admin/Insert/InsertBrand.jsp";
                Integer id = Integer.parseInt(request.getParameter("brandId"));
                brand = brandService.findById(id);
                request.setAttribute("BrandModel", brand);
            }
            case "add": {
                brand = HttpUtil.of(request.getReader()).toModel(BrandModel.class);
                brandService.save(brand);

                url = "/views/admin/List/ListBrand.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Brand Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
            }
            case "update": {
                brand = HttpUtil.of(request.getReader()).toModel(BrandModel.class);
                brandService.update(brand);

                request.setAttribute("discountModel", brand);
                url = "/views/admin/Insert/InsertBrand.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Brand Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
            }
            default: {
                BrandModel model = new BrandModel();
                model.setListResult(brandService.findAll());
                request.setAttribute(CoreConstant.MODEL, model);
                url = "/views/admin/List/ListBrand.jsp";
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
