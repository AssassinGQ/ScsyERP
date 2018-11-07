package cn.AssassinG.ScsyERP.User.core.UMS.biz.impl;

import cn.AssassinG.ScsyERP.User.core.Corporation.dao.CorporationDao;
import cn.AssassinG.ScsyERP.User.core.Government.dao.GovernmentDao;
import cn.AssassinG.ScsyERP.User.core.UMS.biz.UserBiz;
import cn.AssassinG.ScsyERP.User.core.UMS.dao.*;
import cn.AssassinG.ScsyERP.User.facade.Corporation.entity.Corporation;
import cn.AssassinG.ScsyERP.User.facade.Government.entity.Government;
import cn.AssassinG.ScsyERP.User.facade.Government.enums.DeptType;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.*;
import cn.AssassinG.ScsyERP.User.facade.UMS.enums.UserType;
import cn.AssassinG.ScsyERP.common.exceptions.DaoException;
import cn.AssassinG.ScsyERP.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private GovernmentDao governmentDao;
    @Autowired
    private CorporationDao corporationDao;

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

    public User findUserByUname(String userName){
        User user = userDao.findByUserName(userName);
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

    @Override
    public String getVcode(String phone) {
        if(phone == null){

        }
        User user_checkphone = this.findUserByPhone(phone);
        return null;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Transactional
    public long getAccount(String token, User user, String name, DeptType dept) {
        if(!token.equals("superadminabcd1234")) {
            return -1;
        }
        if(user.getPhone() == null || StringUtils.isMobileNum(user.getPhone())){
            return -1;
        }
        if(user.getUserType() == null ||
                (user.getUserType().getValue() != UserType.Corporation.getValue() &&
                        user.getUserType().getValue() != UserType.Government.getValue())){
            return -1;
        }
        if(user.getUserType().getValue() == UserType.Government.getValue() &&
            dept == null){
            return -1;
        }
        User user_checkphone = this.findUserByPhone(user.getPhone());
        if(user_checkphone != null){
            return -1;
        }
        //创建基本信息
        long infoId;
        if(user.getUserType().getValue() == UserType.Corporation.getValue()){
            Government government = new Government(dept);
            government.setName(name);
            infoId = governmentDao.insert(government);
            if(government.getName() == null || government.getName().isEmpty()){
                government.setName(Government.class.getSimpleName() + infoId);
                if(governmentDao.update(government) != 1){
                    throw new DaoException("");
                }
            }
        }else{
            Corporation corporation = new Corporation();
            corporation.setName(name);
            infoId = corporationDao.insert(corporation);
            if(corporation.getName() == null || corporation.getName().isEmpty()){
                corporation.setName(Corporation.class.getSimpleName() + infoId);
                if(corporationDao.update(corporation) != 1){
                    throw new DaoException("");
                }
            }
        }
        //创建登录信息
        User user_insert = new User();
        user_insert.setPhone(user.getPhone());
        user_insert.setUserType(user.getUserType());
        user_insert.setUserInfo(infoId);
        if(user.getPassWord() == null || user.getPassWord().isEmpty()){
            user_insert.setPassWord("123456");
        }else{
            user_insert.setPassWord(user.getPassWord());
        }
        long userId = userDao.insert(user_insert);
        if(user.getUserName() == null || user.getUserName().isEmpty()){
            user_insert.setUserName("username" + userId);
            if(userDao.update(user_insert) != -1){
                throw new DaoException("");
            }
        }else{
            User user_checkun = this.findUserByUname(user.getUserName());
            if(user_checkun != null){
                user_insert.setUserName("username" + userId);
                if(userDao.update(user_insert) != -1){
                    throw new DaoException("");
                }
            }
        }
        return userId;
    }

    public boolean changePsw(Long userId, String psw){
        if(userId == null) {
            return false;
        }
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted()){
            return false;
        }
        user.setPassWord(psw);
        if(userDao.update(user) != 1){
            throw new DaoException("");
        }
        return true;
    }

    public Set<Role> findUserRoles(Long userId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return new HashSet<Role>();
        return roleDao.findByUserId(userId);
    }

    public List<Role> findAllRoles() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        return roleDao.listBy(params);
    }

    public Role findRoleByRoleName(String roleName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("isDeleted", false);
        params.put("RoleName", roleName);
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

    public Set<Permission> findUserPermissions(Long userId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return new HashSet<Permission>();
        Set<Role> roles = roleDao.findByUserId(user.getId());
        Set<Permission> permissions = new HashSet<Permission>();
        for(Role role : roles){
            permissions.addAll(permissionDao.findByRoleId(role.getId()));
        }
        return permissions;
    }

    public Set<Permission> findRolePermissions(Long roleId) {
        Role role = roleDao.getById(roleId);
        if(role == null || role.isDeleted())
            return new HashSet<Permission>();
        return permissionDao.findByRoleId(roleId);
    }

    public Set<Permission> findFatherRolePermissions(Long roleId) {
        Role role = roleDao.getById(roleId);
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

    public boolean addPermissionToRole(Long roleId, Long permissionId) {
        Role role = roleDao.getById(roleId);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionId);
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

    public boolean removePermissionFromRole(Long roleId, Long permissionId) {
        Role role = roleDao.getById(roleId);
        if(role == null || role.isDeleted())
            return false;
        Permission permission = permissionDao.getById(permissionId);
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

    public boolean addUserRole(Long userId, Long roleId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleId);
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

    public boolean removeUserRole(Long userId, Long roleId) {
        User user = userDao.getById(userId);
        if(user == null || user.isDeleted())
            return false;
        Role role = roleDao.getById(roleId);
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
