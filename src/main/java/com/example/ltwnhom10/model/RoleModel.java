package com.example.ltwnhom10.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
@Entity
@Table(name="roles")
public class RoleModel{
    @Id
    @Column(name = "role_id",nullable=false)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roleModel",fetch = FetchType.LAZY)
    private List<UsersModel> userList;
}
