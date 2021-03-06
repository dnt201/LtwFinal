package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.*;
import com.example.ltwnhom10.service.IOrderDetailsService;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.OrderDetailsService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.Bcrypt;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.HttpUtil;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateProfileController", urlPatterns = {"/me"})
public class UpdateProfileController extends HttpServlet {

    @Inject
    private IUserService userService;
    private IOrderDetailsService orderDetailsService;

    public UpdateProfileController() {
        this.userService = new UserService();
        this.orderDetailsService = new OrderDetailsService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);

        if (action == null) {
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login?action=login&&message=not-yet-login");
            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute(CoreConstant.MODEL, user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userDetail.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (action != null && action.equals("update-profile")) {
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login?action=login&&message=not-yet-login");
            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute(CoreConstant.MODEL, user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userUpdateProfile.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login?action=login&&message=not-yet-login");
            } else {
                UsersModel user1 = FormUtil.toModel(UsersModel.class, request);
                UsersModel userModel = new UsersModel();

                userModel = userService.findByID(user1.getUser_id());

                userModel.setName(user1.getName());
                userModel.setEmail(user1.getEmail());
                userModel.setAddress(user1.getAddress());
                userModel.setPhone(user1.getPhone());

                userService.update(userModel);
                SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
                request.setAttribute(CoreConstant.MODEL, userModel);
                SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, userModel);
                request.setAttribute("messageResponse", "Thay ?????i th??ng tin th??nh c??ng!");

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userUpdateProfile.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (action != null && action.equals("change-password")) {
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login?action=login&&message=not-yet-login");
            } else {
                List<OrderDetailsModel> listOrder = orderDetailsService.findByUserId(user.getUser_id());
                request.setAttribute("orders", listOrder);
                request.setAttribute(CoreConstant.MODEL, user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userChangePassword.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userDetail.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        UsersModel userCur = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
        if (userCur == null) {
            response.sendRedirect(request.getContextPath() + "/login?action=login&&message=not-yet-login");
        } else {
            if (action != null && action.equals("change")) {
                System.out.println("V?? elsse");
                Integer user_id = Integer.parseInt(request.getParameter("user_id"));
                String newPassword = request.getParameter("password");
                String curPassword = request.getParameter("curPassword");
                UsersModel userModel = new UsersModel();
                userModel = userService.findByID(user_id);



                Bcrypt bcrypt = new Bcrypt(10);
                if (!(bcrypt.verifyAndUpdateHash(curPassword, userModel.getPassword()))) {
                    //Curent password wrong
                    System.out.println("Sai pass");
                    request.setAttribute("messageResponse", "M???t kh???u hi???n t???i kh??ng ????ng");
                    request.setAttribute(CoreConstant.MODEL, userModel);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userChangePassword.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    //update new password then update user
                    System.out.println("????ng pass");
                    String password = bcrypt.hash(newPassword);
                    userModel.setPassword(password);
                    userService.update(userModel);
                    SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);
                    request.setAttribute(CoreConstant.MODEL, userModel);
                    SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, userModel);

                    request.setAttribute("messageResponse", "Thay ?????i m???t kh???u th??nh c??ng!");

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userChangePassword.jsp");
                    requestDispatcher.forward(request, response);
                }
            }
        }
        doGet(request, response);
    }
}
