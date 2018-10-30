package cn.AssassinG.ScsyERP.User.facade.UMS.service;

import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.User;

import java.util.List;
import java.util.Set;

public interface UserServiceFacade {
    public long create(User user);
    public boolean update(User user);
    public void deleteUserById(Long userId);
    public User findUserById(Long userId);
    public User findUserByUname(String username);
    public User findUserByPhone(String phone);
    public Set<Role> findUserRoles(Long userid);
    public List<Role> findAllRoles();
    public Role findRoleByRoleName(String rolename);
    public Set<Permission> findUserPermissions(Long userid);
    public Set<Permission> findRolePermissions(Long roleid);
    public Set<Permission> findFatherRolePermissions(Long roleid);
    public List<Permission> findAllPermission();
    public boolean addPermissionToRole(Long roleid, Long permissionid);
    public  boolean removePermissionFromRole(Long roleid, Long permissionid);
    public boolean addUserRole(Long userid, Long roleid);
    public boolean removeUserRole(Long userid, Long roleid);
}
