package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.service.IDiscountService;
import com.example.ltwnhom10.service.impl.DiscountService;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountAdmin", urlPatterns = {"/admin/discount"})
public class DiscountController extends HttpServlet {
    private IDiscountService discountService;
    DiscountModel discount = new DiscountModel();

    public DiscountController() {
        this.discountService = new DiscountService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        DiscountModel discount = null;
        String action = request.getParameter("action");
        if (action == null) {
            DiscountModel model = new DiscountModel();
            model.setListResult(discountService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "/views/admin/list/DiscountList.jsp";
        }
        else if (action.equals(CoreConstant.ACTION_INSERT)){
            url = "/views/admin/insert/DiscountInsert.jsp";
        }
        else if (action.equals(CoreConstant.ACTION_EDIT)){
            url = "/views/admin/insert/DiscountInsert.jsp";
            Integer id = Integer.parseInt(request.getParameter("discount_id"));
            discount = discountService.findByID(id);
            request.setAttribute("discountModel", discount);
        }
        else if (action.equals(CoreConstant.ACTION_ADD)){
            discount = FormUtil.toModel(DiscountModel.class, request);
            discountService.save(discount);
            //url = "/views/admin/List/ListDiscount.jsp";
            url = "/views/web/adminPage.jsp";
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Success");
            request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
        }
        else if (action.equals(CoreConstant.ACTION_UPDATE)) {
            discount = FormUtil.toModel(DiscountModel.class, request);
            discountService.update(discount);

            request.setAttribute("discountModel", discount);
            url = "/views/admin/insert/DiscountInsert.jsp";
            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Discount Success");
        }
        else {
            DiscountModel model = new DiscountModel();
            model.setListResult(discountService.findAll());
            request.setAttribute(CoreConstant.MODEL, model);
            url = "/views/admin/list/DiscountList.jsp";
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
