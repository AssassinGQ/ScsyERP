package cn.AssassinG.ScsyERP.User.core.UMS.biz;

import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;

import java.util.List;
import java.util.Set;

public interface UserBiz {
    long create(User user);
    boolean update(User user);
    void deleteUserById(Long userId);
    User findUserById(Long userId);
    User findUserByUname(String username);
    User findUserByPhone(String phone);
    Set<Role> findUserRoles(Long userid);
    List<Role> findAllRoles();
    Role findRoleByRoleName(String rolename);
//    List<Role> findRolesInherit();
//    List<Role> findChileRoles(Long fatherid);
    Set<Permission> findUserPermissions(Long userid);
    Set<Permission> findRolePermissions(Long roleid);
    Set<Permission> findFatherRolePermissions(Long roleid);
//    Set<Permission> findInheritRolePermissions(Long roleid);
    List<Permission> findAllPermission();
    boolean addPermissionToRole(Long roleid, Long permissionid);
    boolean removePermissionFromRole(Long roleid, Long permissionid);
    boolean addUserRole(Long userid, Long roleid);
    boolean removeUserRole(Long userid, Long roleid);
}
