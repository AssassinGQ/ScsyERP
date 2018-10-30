package TestMyBatis.Dao;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.PermissionDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Permission;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestPermission {
    private static Logger logger = Logger.getLogger(TestPermission.class);

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void testGetById() {
        Long permission_id = 1L;
        logger.info("The permission who's id = "+permission_id+" : "+permissionDao.getById(permission_id));
    }

    @Test
    public void testInsert() {
        Permission permission = new Permission();
        permission.setPermissionName("asddf");
        permissionDao.insert(permission);
        Long id = permission.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + permissionDao.getById(id));
    }

    @Test
    public void testBatchInsert() {
        Permission permission = new Permission();
        permission.setPermissionName("asddf3");
        Permission permission2 = new Permission();
        permission2.setPermissionName("asddf4");
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission);
        permissions.add(permission2);
        permissionDao.insert(permissions);
        if(permissions.get(0).getId() != null)
            logger.info("Inserted : " + permissionDao.getById(permissions.get(0).getId()));
        if(permissions.get(1).getId() != null)
            logger.info("Inserted : " + permissionDao.getById(permissions.get(1).getId()));
    }

    @Test
    public void testUpdate() {
        Permission permission = permissionDao.getById(2);
        logger.info("Before Update: "+permission);
        permission.setPermissionName("updatedname3");
        permissionDao.update(permission);
        logger.info("After Updated: " + permissionDao.getById(2));
    }

    @Test
    public void testBatchUpdate() {
        Permission permission2 = permissionDao.getById(2);
        Permission permission4 = permissionDao.getById(4);
        logger.info("Permission2 Before Update: "+permission2);
        logger.info("Permission4 Before Update: "+permission4);
        permission2.setPermissionName("updatedname4");
        permission4.setPermissionName("updatedname5");
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission2);
        permissions.add(permission4);
        permissionDao.update(permissions);
        logger.info("Permission2 After Updated: " + permissionDao.getById(2));
        logger.info("Permission4 After Updated: " + permissionDao.getById(4));
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + permissionDao.getById(delete_id));
        permissionDao.delete(delete_id);
        logger.info("After Deleted " + permissionDao.getById(delete_id));
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Permission permission = permissionDao.getById(delete_id);
        logger.info("Before Delete " + permissionDao.getById(delete_id));
        permissionDao.delete(permission);
        logger.info("After Deleted " + permissionDao.getById(delete_id));
    }

    @Test
    public void testListAll() {
        List<Permission> permissions = permissionDao.listAll();
        for (int i = 0; i < permissions.size(); i++)
            logger.info("Item" + i + ":" + permissions.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        paramMap.put("Id", 1L);
        logger.info(permissionDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("PermissionName", "URL");
        List<Permission> permissions = permissionDao.listBy(paramMap);
        for (int i = 0; i < permissions.size(); i++)
            logger.info("Item" + i + ":" + permissions.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Permission> pageBean = permissionDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Permission> permissions = pageBean.getRecordList();
        for (int i = 0; i < permissions.size(); i++)
            logger.info("Item" + i + ":" + permissions.get(i));
    }

    @Test
    public void testFindByRoleId() {
        Long roleid = 1L;
        logger.info("The role who's id = "+roleid+" has permissions: ");
        Set<Permission> permissions = permissionDao.findByRoleId(roleid);
        for(Permission permission : permissions)
            logger.info(permission);
    }

    @Test
    public void testFindByRoleName() {
        String rolename = "superadmin";
        logger.info("The role who's rolename = "+rolename+" has permissions: ");
        Set<Permission> permissions = permissionDao.findByRolename(rolename);
        for(Permission permission : permissions)
            logger.info(permission);
    }
}
