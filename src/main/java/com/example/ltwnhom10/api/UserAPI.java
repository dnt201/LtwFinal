package com.example.ltwnhom10.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ltwnhom10.model.UsersModel;
import com.example.ltwnhom10.service.IUserService;
import com.example.ltwnhom10.service.impl.UserService;
//import com.example.ltwnhom10.utl.Bcrypt;
import com.example.ltwnhom10.utl.HttpUtil;
import com.example.ltwnhom10.utl.SessionUtil;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "UserAPI", urlPatterns = {"/api/v1/getAllUser"})
public class UserAPI extends HttpServlet {

    private static final long serialVersionUID = 2686801510274002166L;
    @Inject
    private IUserService userService;

    public UserAPI() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<UsersModel> users = userService.findAll();
        mapper.writeValue(resp.getOutputStream(), users);
    }

    //Function add user
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws Error, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        UsersModel userModel = HttpUtil.of(request.getReader()).toModel(UsersModel.class);
        userService.save(userModel);
        mapper.writeValue(response.getOutputStream(), userModel);
    }

    //Function update user
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws Error, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        UsersModel userModel = HttpUtil.of(request.getReader()).toModel(UsersModel.class);
        userService.delete(userModel.getList());
        mapper.writeValue(response.getOutputStream(), "{}");
    }

    //Function delete user
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws Error, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        UsersModel userModel = HttpUtil.of(request.getReader()).toModel(UsersModel.class);
        userService.update(userModel);
        mapper.writeValue(response.getOutputStream(), userModel);
    }
}
