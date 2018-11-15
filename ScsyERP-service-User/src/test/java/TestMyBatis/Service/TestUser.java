package TestMyBatis.Service;

import cn.AssassinG.ScsyERP.User.core.dao.PermissionDao;
import cn.AssassinG.ScsyERP.User.core.dao.RoleDao;
import cn.AssassinG.ScsyERP.User.core.dao.UserDao;
import cn.AssassinG.ScsyERP.User.facade.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.User.facade.service.UserServiceFacade;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestUser {
    private static Logger logger = Logger.getLogger(TestUser.class);

    //测试UserService
    @Autowired
    private UserServiceFacade userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void testSerCreate() {
        User user = new User();
        user.setUserName("duyanting");
        user.setPassWord("123456");
        userService.create(user);
        Long id = user.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + userDao.getById(id));
    }

    @Test
    public void testSerUpdate() {
        User user = userDao.getById(2);
        logger.info("Before Update: "+user);
        user.setUserName("duyanting2");
        user.setPassWord("123456");
        userService.update(user);
        logger.info("After Updated: " + userDao.getById(2));
    }

    @Test
    public void testDeleteUserById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + userDao.getById(delete_id));
        userService.deleteUserById(delete_id);
        logger.info("After Deleted " + userDao.getById(delete_id));
    }

    @Test
    public void testFindUserById() {
        logger.info("Find user who's id = 1: " + userService.findUserById(1L));
    }

    @Test
    public void testFindUserByUname() {
        User user = new User();
        user.setUserName("duyanting");
        user.setPassWord("123456");
        logger.info("Find user who's username = superadmin: " + userService.findUserByUname("superadmin"));
    }

//    @Test
//    public void testFindUserPermission(){
//        String username = "superadmin";
//        Set<Permission> permissions = userService.findUserPermissions(username);
//        logger.info("The user named "+username+" has following permissions:");
//        for(Permission permission : permissions){
//            logger.info(permission);
//        }
//    }

//    @Test
//    public void testFindAll(){
//        logger.info("All permissions in DB:");
//        List<Permission> permissions = userService.findAll();
//        for(Permission permission : permissions){
//            logger.info(permission);
//        }
//    }

    @Test
    public void testAddPermissionToRole(){
        Long role_id = 1L;
        Long permission_id = 2L;
        Set<Permission> permissions = permissionDao.findByRoleId(role_id);
        logger.info("Before The role who's Id = "+role_id+" has permissions:");
        for(Permission permission : permissions)
            logger.info(permission);
        userService.addPermissionToRole(role_id, permission_id);
        logger.info("After The role who's Id = "+role_id+" has permissions:");
        for(Permission permission : permissions)
            logger.info(permission);
    }

    @Test
    public void testRemovePermissionToRole(){
        Long role_id = 1L;
        Long permission_id = 2L;
        Set<Permission> permissions = permissionDao.findByRoleId(role_id);
        logger.info("Before The role who's Id = "+role_id+" has permissions:");
        for(Permission permission : permissions)
            logger.info(permission);
        userService.removePermissionFromRole(role_id, permission_id);
        logger.info("After The role who's Id = "+role_id+" has permissions:");
        for(Permission permission : permissions)
            logger.info(permission);
    }

    @Test
    public void testAddUserRole(){
        Long role_id = 1L;
        Long user_id = 1L;
        Set<Role> roles = roleDao.findByUserId(user_id);
        logger.info("Before The user who's Id = "+user_id+" has roles:");
        for(Role role : roles)
            logger.info(role);
        userService.addUserRole(user_id, role_id);
        logger.info("After The user who's Id = "+user_id+" has roles:");
        for(Role role : roles)
            logger.info(role);
    }

    @Test
    public void testRemoveUserRole(){
        Long role_id = 1L;
        Long user_id = 1L;
        Set<Role> roles = roleDao.findByUserId(user_id);
        logger.info("Before The user who's Id = "+user_id+" has roles:");
        for(Role role : roles)
            logger.info(role);
        userService.removeUserRole(user_id, role_id);
        logger.info("After The user who's Id = "+user_id+" has roles:");
        for(Role role : roles)
            logger.info(role);
    }

    @Test
    public void testFindFatherRolePermissions(){
        Long role_id = 4L;
        Set<Permission> permissions = userService.findFatherRolePermissions(role_id);
        for(Permission permission : permissions)
            logger.info(permission);
    }
}
