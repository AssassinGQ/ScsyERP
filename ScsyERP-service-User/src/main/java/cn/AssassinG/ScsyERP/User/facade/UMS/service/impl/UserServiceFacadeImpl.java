package cn.AssassinG.ScsyERP.User.facade.UMS.service.impl;

import cn.AssassinG.ScsyERP.User.core.UMS.biz.UserBiz;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;
import cn.AssassinG.ScsyERP.User.facade.UMS.service.UserServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Autowired
    private UserBiz userBiz;

    public long create(User user) {
        return userBiz.create(user);
    }

    public boolean update(User user) {
        return userBiz.update(user);
    }

    public void deleteUserById(Long userId) {
        userBiz.deleteUserById(userId);
    }

    public User findUserById(Long userId) {
        return userBiz.findUserById(userId);
    }

    public User findUserByUname(String username) {
        return userBiz.findUserByUname(username);
    }

    public User findUserByPhone(String phone) {
        return userBiz.findUserByPhone(phone);
    }

    public Set<Role> findUserRoles(Long userid) {
        return userBiz.findUserRoles(userid);
    }

    public List<Role> findAllRoles() {
        return userBiz.findAllRoles();
    }

    public Role findRoleByRoleName(String rolename) {
        return userBiz.findRoleByRoleName(rolename);
    }

    public Set<Permission> findUserPermissions(Long userid) {
        return userBiz.findUserPermissions(userid);
    }

    public Set<Permission> findRolePermissions(Long roleid) {
        return userBiz.findRolePermissions(roleid);
    }

    public Set<Permission> findFatherRolePermissions(Long roleid) {
        return userBiz.findFatherRolePermissions(roleid);
    }

    public List<Permission> findAllPermission() {
        return userBiz.findAllPermission();
    }

    public boolean addPermissionToRole(Long roleid, Long permissionid) {
        return userBiz.addPermissionToRole(roleid, permissionid);
    }

    public boolean removePermissionFromRole(Long roleid, Long permissionid) {
        return userBiz.removePermissionFromRole(roleid, permissionid);
    }

    public boolean addUserRole(Long userid, Long roleid) {
        return userBiz.addUserRole(userid, roleid);
    }

    public boolean removeUserRole(Long userid, Long roleid) {
        return userBiz.removeUserRole(userid, roleid);
    }
}
