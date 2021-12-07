package com.example.ltwnhom10.service;

import com.example.ltwnhom10.dao.RoleDao;
import com.example.ltwnhom10.dao.impl.RoleDaoImpl;
import com.example.ltwnhom10.model.RoleModel;
import com.example.ltwnhom10.service.IRoleService;
import java.util.List;
import javax.inject.Inject;

public interface IRoleService {
    public void save(RoleModel roleModel);
    public void update(RoleModel roleModel);
    RoleModel findByID(Integer roleId);
    public Integer delete(List<Integer> list);
    public List<RoleModel> findAll();
    public Integer findRoleByRoleName(String roleName);
}
