package cn.AssassinG.ScsyERP.User.facade.UMS.entity;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class Role extends BaseEntity {
    private String RoleName;
    private String RoleDesc;
    private String SuperRoleName;

    public Role() {
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        RoleDesc = roleDesc;
    }

    public String getSuperRoleName() {
        return SuperRoleName;
    }

    public void setSuperRoleName(String superRoleName) {
        SuperRoleName = superRoleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "RoleName='" + RoleName + '\'' +
                ", RoleDesc='" + RoleDesc + '\'' +
                ", SuperRoleName='" + SuperRoleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (RoleName != null ? !RoleName.equals(role.RoleName) : role.RoleName != null) return false;
        if (RoleDesc != null ? !RoleDesc.equals(role.RoleDesc) : role.RoleDesc != null) return false;
        return SuperRoleName != null ? SuperRoleName.equals(role.SuperRoleName) : role.SuperRoleName == null;
    }

    @Override
    public int hashCode() {
        int result = RoleName != null ? RoleName.hashCode() : 0;
        result = 31 * result + (RoleDesc != null ? RoleDesc.hashCode() : 0);
        result = 31 * result + (SuperRoleName != null ? SuperRoleName.hashCode() : 0);
        return result;
    }
}
