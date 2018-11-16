package cn.AssassinG.ScsyERP.User.core.biz;

import cn.AssassinG.ScsyERP.User.facade.enums.GovernmentDeptType;
import cn.AssassinG.ScsyERP.User.facade.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.common.core.biz.BaseBiz;

import java.util.List;
import java.util.Set;

public interface UserBiz extends BaseBiz<User> {

    //增删查改
    /**
     * @param userName 不能为空或Empty
     * @return null或者User
     * 抛出运行异常：参数不合法、DAO异常
     */
    User findUserByUname(String userName);

    /**
     * @param phone 必须是一个合法的手机号
     * @return null或者User
     * 抛出运行异常：参数不合法、DAO异常、手机号不唯一
     */
    User findUserByPhone(String phone);

    /**
     * @param phone 必须是一个合法的手机号
     * @return 一个String
     * 抛出运行异常：参数不合法、手机号未注册、DAO异常
     */
    //登录注册
    String getVcode(String phone);

    /**
     * @param user
     * @return 是否登录成功
     * 抛出运行异常：参数不合法、用户名未注册、DAO异常
     */
    boolean login(User user);

    /**
     * @param phone 必须是一个合法的手机号
     * @param vcode
     * @param password
     * @return
     * 抛出运行异常：参数不合法、手机号未注册、DAO异常
     */
    boolean ChangePSW(String phone, String vcode, String password);

    /**
     * 生成承运方账号
     * @param token 权限码
     * @param user 上传的登录信息封装后的User
     * @param name 基本信息中的Name字段
     * @return 创建的承运方登录信息的主键
     * 抛出运行异常：权限码不正确、参数不合法、DAO异常
     */
    long createCorporation(String token, User user, String name);

    /**
     * 生成政府账号
     * @param token 权限码
     * @param user 上传的登录信息封装后的User
     * @param name 基本信息中的Name字段
     * @param dept 政府的部门信息
     * @return
     * 抛出运行异常：权限码不正确、参数不合法、DAO异常
     */
    long createGovernment(String token, User user, String name, GovernmentDeptType dept);

    //auth
    /**
     * @param userId
     * @return userId对应的用户拥有的角色集合
     * 抛出运行异常：参数不合法、DAO异常
     */
    Set<Role> findUserRoles(Long userId);

    /**
     * @return 返回所有角色信息的列表
     * 抛出运行异常：DAO异常
     */
    List<Role> findAllRoles();

    /**
     * @param roleName 不能为空
     * @return null或者Role
     * 抛出运行异常：角色名不唯一、DAO异常
     */
    Role findRoleByRoleName(String roleName);

    //    List<Role> findRolesInherit();
    //    List<Role> findChileRoles(Long fatherid);

    /**
     * @param userId 不能为空
     * @return 权限集合
     * 抛出运行异常：参数不合法、DAO异常
     */
    Set<Permission> findUserPermissions(Long userId);

    /**
     * @param roleId 不能为空
     * @return 权限集合
     * 抛出运行异常：参数不合法、DAO异常
     */
    Set<Permission> findRolePermissions(Long roleId);

    /**
     * 获得所有父角色的全部权限集合
     * @param roleId 不能为空
     * @return
     * 抛出运行异常：角色名称不唯一、参数不合法、DAO异常
     */
    Set<Permission> findFatherRolePermissions(Long roleId);
//    Set<Permission> findInheritRolePermissions(Long roleId);

    /**
     * @return 返回所有权限信息的列表
     * 抛出运行异常：DAO异常
     */
    List<Permission> findAllPermission();

    /**
     * @param roleId 不能为空
     * @param permissionId 不能为空
     * @return
     * 抛出运行异常：参数不合法、DAO异常
     */
    boolean addPermissionToRole(Long roleId, Long permissionId);

    /**
     * @param roleId 不能为空
     * @param permissionId 不能为空
     * @return
     * 抛出运行异常：参数不合法、DAO异常
     */
    boolean removePermissionFromRole(Long roleId, Long permissionId);

    /**
     * @param userId 不能为空
     * @param roleId 不能为空
     * @return
     * 抛出运行异常：参数不合法、DAO异常
     */
    boolean addUserRole(Long userId, Long roleId);

    /**
     * @param userId 不能为空
     * @param roleId 不能为空
     * @return
     * 抛出运行异常：参数不合法、DAO异常
     */
    boolean removeUserRole(Long userId, Long roleId);
}
