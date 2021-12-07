package com.example.ltwnhom10.dao;

import com.example.ltwnhom10.model.UsersModel;

public interface UserDao  extends GenericDao<Integer, UsersModel>{
    UsersModel findUserByUsername(String userName);
    UsersModel findUserByUsernameAndPassword(String username, String password);
}
