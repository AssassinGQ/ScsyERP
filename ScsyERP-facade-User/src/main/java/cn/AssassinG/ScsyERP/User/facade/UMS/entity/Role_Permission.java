package cn.AssassinG.ScsyERP.User.facade.UMS.entity;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class Role_Permission extends BaseEntity {
    private Long RoleId;
    private Long PermissionId;

    public Role_Permission() {
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }
}
