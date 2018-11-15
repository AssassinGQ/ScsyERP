package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class User_Role extends BaseEntity {
    private Long UserId;
    private Long RoleId;

    public User_Role() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "UserId=" + UserId +
                ", RoleId=" + RoleId +
                '}';
    }
}
