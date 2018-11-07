package cn.AssassinG.ScsyERP.User.facade.UMS.entity;

import cn.AssassinG.ScsyERP.User.facade.UMS.enums.UserPermissionType;

public class User_Permission {
    private Long UserId;
    private Long PermissionId;
    private UserPermissionType Type;

    public User_Permission() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }

    public UserPermissionType getType() {
        return Type;
    }

    public void setType(UserPermissionType type) {
        Type = type;
    }
}
