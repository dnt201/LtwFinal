package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.UsersModel;
//import com.myshop.paging.Pageble;
import java.util.List;

public interface IUserService {
    //public List<UsersModel> findAllPaging(Pageble pageble);
    Integer delete(List<Integer> list);
    void save(UsersModel userModel);
    void update(UsersModel userModel);
    UsersModel findByID(Integer userId);
    List<UsersModel> findAll();
    Integer getTotalItem();
    UsersModel isUserExist(UsersModel model);
    UsersModel findUserByUsername(String username);
    UsersModel findByUsernameAndPassword(String username, String password);
}
