package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.Bcrypt;
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

@WebServlet(name = "UpdateProfileController", urlPatterns = {"/update-profile","/user"})
public class UpdateProfileController  extends HttpServlet {

    @Inject
    private IUserService userService;
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("update")){
            UsersModel user = HttpUtil.of(request.getReader()).toModel(UsersModel.class);

            Bcrypt bcrypt = new Bcrypt(10);
            String password = bcrypt.hash(user.getPassword());
            user.setPassword(password);
            userService.update(user);

            SessionUtil.getInstance().removeValue(request, CoreConstant.SESSION_DATA);

            user = userService.findUserByUsername(user.getUsername());
            SessionUtil.getInstance().putValue(request, CoreConstant.SESSION_DATA, user);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/userDetail.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
