package com.example.ltwnhom10.controller.Web;

import com.example.ltwnhom10.constance.CoreConstant;
import com.example.ltwnhom10.model.RoleModel;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.RoleService;
import com.example.ltwnhom10.service.impl.UserService;
import com.example.ltwnhom10.utl.Bcrypt;
import com.example.ltwnhom10.utl.FormUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServerException, IOException{

        RoleService roleService = new RoleService();

        IUserService userService = new UserService();
        UsersModel usersModel = FormUtil.toModel(UsersModel.class, request);
        UsersModel userExist = userService.isUserExist(usersModel);

        if (userExist != null)
            response.sendRedirect(request.getContextPath()+"/login?action=login&&messageResponse=User_has_exist&&alert=danger");
        else
        {
            RoleModel role = new RoleModel();
            usersModel.setRoleModel(role);

            Integer role_id = roleService.findRoleByRoleName(CoreConstant.ROLE_USER);
            usersModel.getRoleModel().setRoleId(role_id);

            Bcrypt bcrypt = new Bcrypt(10);
            String password = bcrypt.hash(usersModel.getPassword());
            usersModel.setPassword(password);

            userService.save(usersModel);

            request.setAttribute("messageResponse", "Signup Success");
            request.setAttribute("alert", CoreConstant.TYPE_SUCCESS);

            response.sendRedirect(request.getContextPath() + "/login?action=login");
        }
    }
}
