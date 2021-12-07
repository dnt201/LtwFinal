package com.example.ltwnhom10.service.impl;


import com.example.ltwnhom10.dao.UserDao;
import com.example.ltwnhom10.dao.impl.UserDaoImpl;
import com.example.ltwnhom10.model.UsersModel;
//import com.example.ltwnhom10.paging.Pageble;
import com.example.ltwnhom10.service.IUserService;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author asus
 */
public  class UserService implements IUserService {

  @Inject
  private UserDao userDAO;

  public UserService() {
    userDAO = new UserDaoImpl();
  }

  @Override
  public void save(UsersModel userModel) {
    userModel.setCreateAt(Timestamp.from(Instant.now()));
    userDAO.save(userModel);
  }

  @Override
  public void update(UsersModel userModel) {
    userDAO.update(userModel);
  }

  @Override
  public UsersModel findByID(Integer userId) {
    UsersModel userModel = userDAO.findById(userId);
    return userModel;
  }

  /*@Override
  //public Integer delete(List<Integer> ids) {
  //return userDAO.delete(ids);
  //}

  @Override
  public UsersModel isUserExist(UsersModel model) {
    return userDAO.findUserByUsername(model.getUserName());
  }

  @Override
  public List<UsersModel> findAllPaging(Pageble pageble) {
    return userDAO.findAllPaging(pageble);
  }
*/

  @Override
  public List<UsersModel> findAll() {
    return userDAO.findAll();
  }

  @Override
  public Integer getTotalItem() {
    return userDAO.findAll().size();
  }

}
