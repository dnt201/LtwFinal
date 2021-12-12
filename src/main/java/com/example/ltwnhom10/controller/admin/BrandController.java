package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.BrandModel;
import com.example.ltwnhom10.model.OrderItemsModel;
import com.example.ltwnhom10.model.ProductModel;
import com.example.ltwnhom10.service.IBrandService;
import com.example.ltwnhom10.service.IProductService;
import com.example.ltwnhom10.service.impl.BrandService;
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
import java.util.List;

@WebServlet(name = "BrandAdmin", urlPatterns = {"/admin/brand"})
public class BrandController extends HttpServlet {
    private IBrandService brandService;
    private IProductService productService;

    public BrandController() {
        this.brandService = new BrandService();
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BrandModel brand = null;
        String url = "";
        String action = request.getParameter("action");
        if (action == null) {
            BrandModel model = new BrandModel();
            model.setListResult(brandService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "/views/admin/list/BrandList.jsp";
        }
        else if (action.equals(CoreConstant.ACTION_INSERT)) {
            url = "/views/admin/insert/BrandInsert.jsp";
        }
        else if (action.equals(CoreConstant.ACTION_EDIT)) {
            url = "/views/admin/insert/BrandInsert.jsp";
            Integer id = Integer.parseInt(request.getParameter("brand_id"));
            brand = brandService.findById(id);
            request.setAttribute("BrandModel", brand);
        }
        else if (action.equals(CoreConstant.ACTION_ADD)) {
            brand = FormUtil.toModel(BrandModel.class, request);
            if (brand != null) {
                if (brandService.findByName(brand.getBrand_name()) == null) {
                    brandService.save(brand);
                    url = "/views/admin/insert/BrandInsert.jsp";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Brand Success");
                }
                else {
                    url = "/views/admin/insert/BrandInsert.jsp";
                    request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Brand Exist. Can not add new");
                }
            }
        }
        else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            brand = FormUtil.toModel(BrandModel.class, request);
            if (brandService.findByName(brand.getBrand_name()) == null) {
                brandService.update(brand);
                request.setAttribute("BrandModel", brand);
                url = "/views/admin/insert/BrandInsert.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Brand Success");
            }
            else {
                url = "/views/admin/insert/BrandInsert.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Brand Exist. Can not Update");
            }
        }
        else if (action.equals(CoreConstant.ACTION_DELETE)){
            Integer id = Integer.parseInt(request.getParameter("brand_id"));
            List<ProductModel> productModels = productService.findByBrand(id);

            if (productModels.size() > 0){
                url = "/views/admin/list/BrandList.jsp";
                BrandModel model = new BrandModel();
                model.setListResult(brandService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Fail");
            }
            else {
                url = "/views/admin/list/BrandList.jsp";
                brandService.deleteOne(brandService.findById(id));

                BrandModel model = new BrandModel();
                model.setListResult(brandService.findAll());

                request.setAttribute(CoreConstant.MODEL, model);
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Delete Brand Success");
            }
        }
        else {
            BrandModel model = new BrandModel();
            model.setListResult(brandService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "/views/admin/list/BrandList.jsp";
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