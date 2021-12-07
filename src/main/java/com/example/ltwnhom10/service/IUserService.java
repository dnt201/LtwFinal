package com.example.ltwnhom10.service;

import com.example.ltwnhom10.model.UsersModel;
//import com.myshop.paging.Pageble;
import java.util.List;

public interface IUserService {
    //UsersModel findByUserNameAndPassword(String userName, String password);
    //public List<UsersModel> findAllPaging(Pageble pageble);
    //public Integer delete(List<Integer> ids);
    //Long delete(UsersModel usersModel);
    void save(UsersModel userModel);
    void update(UsersModel userModel);
    UsersModel findByID(Integer userId);
    List<UsersModel> findAll();
    Integer getTotalItem();
   // UsersModel isUserExist(UsersModel model);
}
