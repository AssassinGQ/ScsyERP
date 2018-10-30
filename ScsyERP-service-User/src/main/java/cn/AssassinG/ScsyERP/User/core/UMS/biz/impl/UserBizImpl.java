package cn.AssassinG.ScsyERP.User.core.UMS.biz.impl;

import cn.AssassinG.ScsyERP.User.core.UMS.biz.UserBiz;
import cn.AssassinG.ScsyERP.User.core.UMS.dao.*;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("UserBiz")
public class UserBizImpl implements UserBiz {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public long create(User user) {
        return userDao.insert(user);
    }

    public boolean update(User user) {
        int result = userDao.update(user);
        return result == 1;
    }

    public User findUserById(Long userId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return null;
        else
            return user;
    }

    public void deleteUserById(Long userId) {
        User user = userDao.getById(userId);
        if (user != null) {
            userDao.delete(user.getId());
        }
    }

    public User findUserByUname(String username){
        User user = userDao.findByUserName(username);
        if(user == null || user.isDeleted())
            return null;
        else
            return user;
    }

    public User findUserByPhone(String phone){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        params.put("Phone", phone);
        List<User> users = userDao.listBy(params);
        if(users.size() > 1){
            return users.get(0);
        }else if(users.size() == 1){
            return users.get(0);
        }else
            return null;
    }

    public Set<Role> findUserRoles(Long userid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return new HashSet<Role>();
        return roleDao.findByUserId(userid);
    }

    public List<Role> findAllRoles() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        return roleDao.listBy(params);
    }

    public Role findRoleByRoleName(String rolename) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        params.put("RoleName", rolename);
        List<Role> roles = roleDao.listBy(params);
        if(roles.size() >= 1)
            return roles.get(0);
        else
            return  null;
    }

//    @Override
//    public List<Role> findRolesInherit() {
//        return null;
//    }
//
//    @Override
//    public List<Role> findChileRoles(Long fatherid) {
//        if(fatherid == null || fatherid.longValue() < 0)
//            return new ArrayList<Role>();
//        List<Role> ret = new ArrayList<Role>();
//        if(fatherid.longValue() == 0) {
//            ret.add(roleDao.getById(1L));
//            return ret;
//        }
//        Role father_role = roleDao.getById(fatherid);
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("SuperRoleName", father_role.getRoleName());
//        ret = roleDao.listBy(params);
//        return ret;
//    }

    public Set<Permission> findUserPermissions(Long userid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return new HashSet<Permission>();
        Set<Role> roles = roleDao.findByUserId(user.getId());
        Set<Permission> permissions = new HashSet<Permission>();
        for(Role role : roles){
            permissions.addAll(permissionDao.findByRoleId(role.getId()));
        }
        return permissions;
    }

    public Set<Permission> findRolePermissions(Long roleid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return new HashSet<Permission>();
        return permissionDao.findByRoleId(roleid);
    }

    public Set<Permission> findFatherRolePermissions(Long roleid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return new HashSet<Permission>();
        Set<Permission> permissions = new HashSet<Permission>();
        Role thisrole = role;
        while(thisrole.getSuperRoleName() != null){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("isDeleted", false);
            params.put("RoleName", thisrole.getSuperRoleName());
            List<Role> super_roles = roleDao.listBy(params);
            if(super_roles.size() >= 1){
                thisrole = super_roles.get(0);
            }else{
                thisrole = null;
            }
            permissions.addAll(permissionDao.findByRoleId(thisrole.getId()));
        }
        return permissions;
    }

//    @Override
//    public Set<Permission> findInheritRolePermissions(Long roleid) {
//        Role role = roleDao.getById(roleid);
//        if(role == null || role.IsDeleted())
//            return new HashSet<Permission>();
//        Set<Role> roles = new HashSet<Role>();
//        roles.add(role);
//        Queue<Role> queue = new LinkedList<Role>();
//        queue.offer(role);
//        while(queue.size() > 0){
//            Role tmprole = queue.poll();
//            Map<String, Object> params = new HashMap<String, Object>();
//            params.put("SuperRoleName", tmprole.getRoleName());
//            List<Role> tmproles = roleDao.listBy(params);
//            roles.addAll(tmproles);
//            for(Role r : tmproles){
//                queue.offer(r);
//            }
//        }
//        Set<Permission> permissions = new HashSet<Permission>();
//        for(Role role1 : roles){
//            permissions.addAll(permissionDao.findByRoleId(role1.getId()));
//        }
//        return permissions;
//    }

    public List<Permission> findAllPermission() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        return permissionDao.listBy(params);
    }

    public boolean addPermissionToRole(Long roleid, Long permissionid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionid);
        if(permission == null || permission.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("RoleId", role.getId());
        params.put("PermissionId", permission.getId());
        Role_Permission role_permission = rolePermissionDao.getBy(params);
        if(role_permission == null){
            Role_Permission role_permission_new = new Role_Permission();
            role_permission_new.setRoleId(role.getId());
            role_permission_new.setPermissionId(permission.getId());
            rolePermissionDao.insert(role_permission_new);
            return true;
        }else{
            if(role_permission.isDeleted()){
                role_permission.setDeleted(false);
                rolePermissionDao.update(role_permission);
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean removePermissionFromRole(Long roleid, Long permissionid) {
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionid);
        if(permission == null || permission.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("RoleId", role.getId());
        params.put("PermissionId", permission.getId());
        Role_Permission role_permission = rolePermissionDao.getBy(params);
        if(role_permission == null || role_permission.isDeleted()){
            return false;
        }else{
            rolePermissionDao.delete(role_permission);
            return true;
        }
    }

    public boolean addUserRole(Long userid, Long roleid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("UserId", user.getId());
        params.put("RoleId", role.getId());
        User_Role user_role = userRoleDao.getBy(params);
        if(user_role == null){
            User_Role user_role_new = new User_Role();
            user_role_new.setUserId(user.getId());
            user_role_new.setRoleId(role.getId());
            userRoleDao.insert(user_role_new);
            return true;
        }else{
            if(user_role.isDeleted()){
                user_role.setDeleted(false);
                userRoleDao.update(user_role);
                return true;
            }else
                return false;
        }
    }

    public boolean removeUserRole(Long userid, Long roleid) {
        User user = userDao.getById(userid);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleid);
        if(role == null || role.isDeleted())
            return false;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("UserId", user.getId());
        params.put("RoleId", role.getId());
        User_Role user_role = userRoleDao.getBy(params);
        if(user_role == null || user_role.isDeleted()){
            return false;
        }else{
            userRoleDao.delete(user_role);
            return true;
        }
    }
}
