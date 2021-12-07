package com.example.ltwnhom10.service.impl;

import com.example.ltwnhom10.dao.RoleDao;
import com.example.ltwnhom10.dao.impl.RoleDaoImpl;
import com.example.ltwnhom10.model.RoleModel;
import com.example.ltwnhom10.service.IRoleService;
import java.util.List;
import javax.inject.Inject;

public class RoleService implements IRoleService{
    @Inject
    private RoleDao roleDAO;

    public RoleService() {
        roleDAO = new RoleDaoImpl();
    }

    @Override
    public void save(RoleModel roleModel) {
        roleDAO.save(roleModel);
    }

    @Override
    public void update(RoleModel roleModel) {
        roleDAO.update(roleModel);
    }

    @Override
    public RoleModel findByID(Integer roleId) {
        return roleDAO.findById(roleId);
    }

    /*@Override
    public Integer delete(List<Integer> ids) {
        return roleDAO.delete(ids);
    }
     */

    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }

}
