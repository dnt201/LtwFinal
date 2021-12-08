package com.example.ltwnhom10.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
@Entity
@Table(name="roles")
public class RoleModel extends AbstractModel<UsersModel> {
    @Id
    @Column(name = "role_id",nullable=false)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roleModel",fetch = FetchType.LAZY)
    private List<UsersModel> userList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UsersModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UsersModel> userList) {
        this.userList = userList;
    }
}
