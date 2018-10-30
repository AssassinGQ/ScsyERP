package TestMyBatis.Dao;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.RolePermissionDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role_Permission;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestRolePermission {
    private static Logger logger = Logger.getLogger(TestRolePermission.class);
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Test
    public void testGetById() {
        Long role_permission_id = 1L;
        logger.info("The role_permission who's id = "+role_permission_id+" : "+rolePermissionDao.getById(role_permission_id));
    }

    @Test
    public void testInsert() {
        Role_Permission role_permission = new Role_Permission();
        role_permission.setPermissionId(1L);
        rolePermissionDao.insert(role_permission);
        Long id = role_permission.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + rolePermissionDao.getById(id));
    }

    @Test
    public void testBatchInsert() {
        Role_Permission role_permission = new Role_Permission();
        role_permission.setPermissionId(1L);
        Role_Permission role_permission2 = new Role_Permission();
        role_permission2.setPermissionId(2L);
        List<Role_Permission> role_permissions = new ArrayList<Role_Permission>();
        role_permissions.add(role_permission);
        role_permissions.add(role_permission2);
        rolePermissionDao.insert(role_permissions);
        if(role_permissions.get(0).getId() != null)
            logger.info("Inserted : " + rolePermissionDao.getById(role_permissions.get(0).getId()));
        if(role_permissions.get(1).getId() != null)
            logger.info("Inserted : " + rolePermissionDao.getById(role_permissions.get(1).getId()));
    }

    @Test
    public void testUpdate() {
        Role_Permission role_permission = rolePermissionDao.getById(2);
        logger.info("Before Update: "+role_permission);
        role_permission.setPermissionId(1L);
        rolePermissionDao.update(role_permission);
        logger.info("After Updated: " + rolePermissionDao.getById(2));
    }

    @Test
    public void testBatchUpdate() {
        Role_Permission role_permission2 = rolePermissionDao.getById(2);
        Role_Permission role_permission4 = rolePermissionDao.getById(4);
        logger.info("Role_Permission2 Before Update: "+role_permission2);
        logger.info("Role_Permission4 Before Update: "+role_permission4);
        role_permission2.setPermissionId(1L);
        role_permission4.setPermissionId(1L);
        List<Role_Permission> role_permissions = new ArrayList<Role_Permission>();
        role_permissions.add(role_permission2);
        role_permissions.add(role_permission4);
        rolePermissionDao.update(role_permissions);
        logger.info("Role_Permission2 After Updated: " + rolePermissionDao.getById(2));
        logger.info("Role_Permission4 After Updated: " + rolePermissionDao.getById(4));
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + rolePermissionDao.getById(delete_id));
        rolePermissionDao.delete(delete_id);
        logger.info("After Deleted " + rolePermissionDao.getById(delete_id));
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Role_Permission role_permission = rolePermissionDao.getById(delete_id);
        logger.info("Before Delete " + rolePermissionDao.getById(delete_id));
        rolePermissionDao.delete(role_permission);
        logger.info("After Deleted " + rolePermissionDao.getById(delete_id));
    }

    @Test
    public void testListAll() {
        List<Role_Permission> role_permissions = rolePermissionDao.listAll();
        for (int i = 0; i < role_permissions.size(); i++)
            logger.info("Item" + i + ":" + role_permissions.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        paramMap.put("Id", 1L);
        logger.info(rolePermissionDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("rIole_permissionname", "admi");
        List<Role_Permission> role_permissions = rolePermissionDao.listBy(paramMap);
        for (int i = 0; i < role_permissions.size(); i++)
            logger.info("Item" + i + ":" + role_permissions.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Role_Permission> pageBean = rolePermissionDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Role_Permission> role_permissions = pageBean.getRecordList();
        for (int i = 0; i < role_permissions.size(); i++)
            logger.info("Item" + i + ":" + role_permissions.get(i));
    }
}
