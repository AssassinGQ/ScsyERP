package TestMyBatis.Dao;

import cn.AssassinG.ScsyERP.User.core.UMS.dao.RoleDao;
import cn.AssassinG.ScsyERP.User.facade.UMS.entity.Role;
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
public class TestRole {
    private static Logger logger = Logger.getLogger(TestRole.class);
    @Autowired
    private RoleDao roleDao;

    @Test
    public void testGetById() {
        Long role_id = 1L;
        logger.info("The role who's id = "+role_id+" : "+roleDao.getById(role_id));
    }

    @Test
    public void testInsert() {
        Role role = new Role();
        role.setRoleName("duyanting");
        roleDao.insert(role);
        Long id = role.getId();
        if(id == null){
            logger.info("Inserted nothing");
        }else
            logger.info("Inserted : " + roleDao.getById(id));
    }

    @Test
    public void testBatchInsert() {
        Role role = new Role();
        role.setRoleName("duyanting3");
        Role role2 = new Role();
        role2.setRoleName("duyanting4");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        roles.add(role2);
        roleDao.insert(roles);
        if(roles.get(0).getId() != null)
            logger.info("Inserted : " + roleDao.getById(roles.get(0).getId()));
        if(roles.get(1).getId() != null)
            logger.info("Inserted : " + roleDao.getById(roles.get(1).getId()));
    }

    @Test
    public void testUpdate() {
        Role role = roleDao.getById(2);
        logger.info("Before Update: "+role);
        role.setRoleName("updatedname3");
        roleDao.update(role);
        logger.info("After Updated: " + roleDao.getById(2));
    }

    @Test
    public void testBatchUpdate() {
        Role role2 = roleDao.getById(2);
        Role role4 = roleDao.getById(4);
        logger.info("Role2 Before Update: "+role2);
        logger.info("Role4 Before Update: "+role4);
        role2.setRoleName("updatedname4");
        role4.setRoleName("updatedname5");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role2);
        roles.add(role4);
        roleDao.update(roles);
        logger.info("Role2 After Updated: " + roleDao.getById(2));
        logger.info("Role4 After Updated: " + roleDao.getById(4));
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        logger.info("Before Delete " + roleDao.getById(delete_id));
        roleDao.delete(delete_id);
        logger.info("After Deleted " + roleDao.getById(delete_id));
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Role role = roleDao.getById(delete_id);
        logger.info("Before Delete " + roleDao.getById(delete_id));
        roleDao.delete(role);
        logger.info("After Deleted " + roleDao.getById(delete_id));
    }

    @Test
    public void testListAll() {
        List<Role> roles = roleDao.listAll();
        for (int i = 0; i < roles.size(); i++)
            logger.info("Item" + i + ":" + roles.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", true);
        paramMap.put("Id", 1L);
        logger.info(roleDao.getBy(paramMap));
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("RoleName", "admi");
        List<Role> roles = roleDao.listBy(paramMap);
        for (int i = 0; i < roles.size(); i++)
            logger.info("Item" + i + ":" + roles.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("isDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Role> pageBean = roleDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Role> roles = pageBean.getRecordList();
        for (int i = 0; i < roles.size(); i++)
            logger.info("Item" + i + ":" + roles.get(i));
    }

    @Test
    public void testFindByUserId() {
        Long userid = 1L;
        logger.info("The user who's id = "+userid+" has roles : ");
        Set<Role> roles = roleDao.findByUserId(userid);
        for(Role role : roles)
            logger.info(role);
    }

    @Test
    public void testFindByUserName() {
        String username = "superadmin";
        logger.info("The user who's username= "+username+" has roles : ");
        Set<Role> roles = roleDao.findByUsername(username);
        for(Role role : roles)
            logger.info(role);
    }
}
