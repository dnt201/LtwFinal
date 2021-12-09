package com.example.ltwnhom10.controller.admin;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.DiscountModel;
import com.example.ltwnhom10.service.IDiscountService;
import com.example.ltwnhom10.service.impl.DiscountService;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountAdmin", urlPatterns = {"/admin/discount"})
public class DiscountController extends HttpServlet
{
    private IDiscountService discountService;
    DiscountModel discount = new DiscountModel();

    public DiscountController() { this.discountService = new DiscountService(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url="";
        DiscountModel discount = null;
        String action = request.getParameter("action");

        switch (action){
            case "insert": {
                url = "/views/admin/Insert/InsertDiscount.jsp";
                break;
            }
            case "edit": {
                url = "/views/admin/Insert/InsertDiscount.jsp";
                Integer id = Integer.parseInt(request.getParameter("discount_id"));
                discount = discountService.findByID(id);
                request.setAttribute("discountModel", discount);
                break;
            }
            case "add": {
                discount = FormUtil.toModel(DiscountModel.class, request);
                discountService.save(discount);
                //url = "/views/admin/List/ListDiscount.jsp";
                url = "/views/web/adminPage.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Add Discount Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
                break;
            }
            case "update": {
                discount = FormUtil.toModel(DiscountModel.class, request);
                discountService.update(discount);

                request.setAttribute("discountModel", discount);
                url = "/views/admin/Insert/InsertDiscount.jsp";
                request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Update Discount Success");
                request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);
                break;
            }
            default: {
                discount.setListResult(discountService.findAll());
                request.setAttribute(CoreConstant.MODEL, discount);
                url = "/views/admin/List/ListDiscount.jsp";
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
