package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.RoleModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.RoleService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.Bcrypt;
import com.example.ltwnhom10.utl.FormUtil;
import com.example.ltwnhom10.utl.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (action != null && action.equals("register")){
            String message = request.getParameter("message");
            System.out.println("Đã nhận action kia:"+message);
            System.out.println(message);
            if (message!=null){
                if(message.equals("user_has_exist"))
                    request.setAttribute("messageResponse", "Username đã tồn tại, vui lòng sử dụng username khác!!!");
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/register.jsp");
        requestDispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServerException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        RoleService roleService = new RoleService();
        IUserService userService = new UserService();
        UsersModel usersModel = FormUtil.toModel(UsersModel.class, request);

        UsersModel userExist = userService.isUserExist(usersModel);

        if (userExist != null)
            response.sendRedirect(request.getContextPath()+"/register?action=register&&message=user_has_exist");
        else
        {
            System.out.println("into");
            RoleModel role = new RoleModel();
            usersModel.setRoleModel(role);
            Date date = new Date();
            Timestamp ts =  new Timestamp(date.getTime());
            usersModel.setCreateAt(ts);

            Integer role_id = roleService.findRoleByRoleName(CoreConstant.ROLE_USER);
            usersModel.getRoleModel().setRoleId(role_id);

            Bcrypt bcrypt = new Bcrypt(10);
            String password = bcrypt.hash(usersModel.getPassword());
            usersModel.setPassword(password);

            userService.save(usersModel);

            request.setAttribute(CoreConstant.MESSAGE_RESPONSE, "Signup Success");
            request.setAttribute(CoreConstant.ALERT, CoreConstant.TYPE_SUCCESS);

            response.sendRedirect(request.getContextPath() + "/login?action=login");
        }
    }
}
