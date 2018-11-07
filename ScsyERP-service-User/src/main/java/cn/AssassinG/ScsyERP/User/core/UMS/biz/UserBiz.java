package cn.AssassinG.ScsyERP.User.core.UMS.biz;

import cn.AssassinG.ScsyERP.User.facade.Government.enums.DeptType;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;

import java.util.List;
import java.util.Set;

public interface UserBiz {
    //增删查改
    long create(User user);
    boolean update(User user);
    void deleteUserById(Long userId);
    User findUserById(Long userId);
    User findUserByUname(String userName);
    User findUserByPhone(String phone);
    //登录注册
    String getVcode(String phone);
    boolean register(User user);
    boolean login(User user);
    //生成承运方和政府账号
    long getAccount(String token, User user, String name, DeptType dept);
    //auth
    Set<Role> findUserRoles(Long userId);
    List<Role> findAllRoles();
    Role findRoleByRoleName(String roleName);
//    List<Role> findRolesInherit();
//    List<Role> findChileRoles(Long fatherid);
    Set<Permission> findUserPermissions(Long userId);
    Set<Permission> findRolePermissions(Long roleId);
    Set<Permission> findFatherRolePermissions(Long roleId);
//    Set<Permission> findInheritRolePermissions(Long roleId);
    List<Permission> findAllPermission();
    boolean addPermissionToRole(Long roleId, Long permissionId);
    boolean removePermissionFromRole(Long roleId, Long permissionId);
    boolean addUserRole(Long userId, Long roleId);
    boolean removeUserRole(Long userId, Long roleId);
}
